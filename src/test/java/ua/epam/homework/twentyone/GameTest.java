package ua.epam.homework.twentyone;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

public class GameTest {
	private Game game;
	private Deck deck;
	private PrintStream out;
	private InputStream in;
	private ByteArrayOutputStream outputStream;

	@Before
	public void initGame(){
		in = new ByteArrayInputStream(prepareInputMockByte(""));
		outputStream = new ByteArrayOutputStream();
		out = new PrintStream(outputStream);
		deck = new Deck();
		game = new Game(deck,out,in);
	}

	@Test
	public void dealtCard() throws Exception {
		Card card = new Card(Suit.SPADES,Rank.ACE);
		deck.pushCardInTop(card);
		List<Card> player = new ArrayList<>();
		game.dealtCard(player);
		Assert.assertEquals(1, player.size());
		Assert.assertEquals(true,deck.isEmpty());
		Assert.assertEquals(card,player.get(0));
	}

	@Test
	public void dealtCardToDealer() throws Exception {
		Card card = new Card(Suit.SPADES,Rank.ACE);
		deck.pushCardInTop(card);
		game.dealtCardToDealer();
		Assert.assertEquals(1, game.getDealerCards().size());
		Assert.assertEquals(true,deck.isEmpty());
		Assert.assertEquals(card,game.getDealerCards().get(0));
	}

	@Test
	public void dealtCardToPlayer() throws Exception {
		Card card = new Card(Suit.SPADES,Rank.ACE);
		deck.pushCardInTop(card);
		game.dealtCardToPlayer();
		Assert.assertEquals(1, game.getPlayerCards().size());
		Assert.assertEquals(true,deck.isEmpty());
		Assert.assertEquals(card,game.getPlayerCards().get(0));
	}

	@Test
	public void calculateDealerPoints() throws Exception {
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.FIVE));
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.QUEEN));
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.KING));
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.ACE));

		game.dealtCardToDealer();
		Assert.assertEquals(11, game.calculateDealerPoints());
		game.dealtCardToDealer();
		Assert.assertEquals(21, game.calculateDealerPoints());
		game.dealtCardToDealer();
		Assert.assertEquals(21, game.calculateDealerPoints());
		game.dealtCardToDealer();
		Assert.assertEquals(26, game.calculateDealerPoints());
	}

	@Test
	public void calculatePlayerPoints() throws Exception {
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.FIVE));
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.ACE));
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.QUEEN));
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.KING));

		game.dealtCardToPlayer();
		Assert.assertEquals(10, game.calculatePlayerPoints());
		game.dealtCardToPlayer();
		Assert.assertEquals(20, game.calculatePlayerPoints());
		game.dealtCardToPlayer();
		Assert.assertEquals(21, game.calculatePlayerPoints());
		game.dealtCardToPlayer();
		Assert.assertEquals(26, game.calculatePlayerPoints());
	}

	@Test
	public void calculatePoints() throws Exception {
		List<Card> player = new ArrayList<>();
		player.add(new Card(Suit.SPADES,Rank.FIVE));
		player.add(new Card(Suit.SPADES,Rank.SIX));
		player.add(new Card(Suit.SPADES,Rank.KING));
		Assert.assertEquals(21,game.calculatePoints(player));

	}

	@Test
	public void filterPointsBigger21() throws Exception {
		List points = Arrays.asList(4,33,2,66,21);
		List expected = Arrays.asList(4,2,21);
		List result = game.filterPointsBigger21(points);

		Assert.assertThat(expected, is(result));

	}

	@Test
	public void getPointLessThanBlackjackOrMin() throws Exception {
		List points = Arrays.asList(4,33,2,66,21);
		Integer expected = 21;
		Integer result = game.getPointLessThanBlackjackOrMin(points);
		Assert.assertThat(expected, is(result));
	}

	@Test
	public void getPointLessThanBlackjackOrMinCheckMin() throws Exception {
		List points = Arrays.asList(33,66,22);
		Integer expected = 22;
		Integer result = game.getPointLessThanBlackjackOrMin(points);
		Assert.assertThat(expected, is(result));
	}

	@Test
	public void addPoints() throws Exception {
		List points = Arrays.asList(33,66,22);
		List expected = Arrays.asList(35,68,24);
		List result = game.addPoints(points,2);
		Assert.assertThat(expected, is(result));
	}

	@Test
	public void readUserChar() throws Exception {
		in = new ByteArrayInputStream(prepareInputMockByte("a\n"));
		game = new Game(deck,out,in);
		Assert.assertEquals((Character) 'a', game.readUserChar());
	}

	@Test(expected = NoSuchElementException.class)
	public void readWrongUserChar() throws Exception {
		in = new ByteArrayInputStream(prepareInputMockByte("b\n"));
		game = new Game(deck,out,in);
		Assert.assertEquals((Character) 'a', game.readUserChar());
	}


	@Test
	public void checkOverdeal() throws Exception {
		List<Card> player = new ArrayList<>();
		Assert.assertEquals(false,game.checkOverdeal(player));
		player.add(new Card(Suit.SPADES,Rank.FIVE));
		player.add(new Card(Suit.SPADES,Rank.SIX));
		player.add(new Card(Suit.SPADES,Rank.KING));
		Assert.assertEquals(false,game.checkOverdeal(player));
		player.add(new Card(Suit.SPADES,Rank.ACE));
		Assert.assertEquals(true,game.checkOverdeal(player));

	}

	@Test
	public void printZeroPoints() throws Exception {
		game = new Game(deck,out,in);
		game.printPoints();
		String expected = "Dealer : 0\r\n" +
				"Player : 0\r\n";
		Assert.assertEquals(expected,outputStream.toString() );
	}

	@Test
	public void printNoZeroPoints() throws Exception {
		game = new Game(deck,out,in);
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.FIVE));
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.QUEEN));
		game.dealtCardToPlayer();
		game.dealtCardToDealer();
		game.printPoints();
		Assert.assertThat(outputStream.toString(), containsString("Dealer : 5") );
		Assert.assertThat(outputStream.toString(), containsString("Player : 10") );

	}

	@Test
	public void dealtCardsToDealer() throws Exception {
		Card card = new Card(Suit.SPADES,Rank.ACE);
		deck.pushCardInTop(card);
		game.dealtCardToPlayer();
		Assert.assertEquals(1, game.getPlayerCards().size());
		Assert.assertEquals(true,deck.isEmpty());
		Assert.assertEquals(card,game.getPlayerCards().get(0));
	}

	@Test
	public void dealtCardsToPlayer() throws Exception {
		Card card = new Card(Suit.SPADES,Rank.ACE);
		deck.pushCardInTop(card);
		game.dealtCardToPlayer();
		Assert.assertEquals(1, game.getPlayerCards().size());
		Assert.assertEquals(true,deck.isEmpty());
		Assert.assertEquals(card,game.getPlayerCards().get(0));
	}

	@Test
	public void announceWinnerPlayer() throws Exception {
		game = new Game(deck,out,in);
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.FIVE));
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.QUEEN));
		game.dealtCardToPlayer();
		game.dealtCardToDealer();
		game.announceWinner();
		Assert.assertThat(outputStream.toString(), containsString("You win") );
	}

	@Test
	public void announceWinnerDealer() throws Exception {
		game = new Game(deck,out,in);
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.FIVE));
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.QUEEN));
		game.dealtCardToDealer();
		game.dealtCardToPlayer();
		game.announceWinner();
		Assert.assertThat(outputStream.toString(), containsString("You lose") );
	}

	@Test
	public void checkBlackJack() throws Exception {
		List<Card> player = new ArrayList<>();
		player.add(new Card(Suit.SPADES,Rank.ACE));
		player.add(new Card(Suit.SPADES,Rank.KING));
		Assert.assertEquals(true,game.checkBlackJack(player));
	}

	@Test
	public void checkBlackJackIsFalse() throws Exception {
		List<Card> player = new ArrayList<>();
		player.add(new Card(Suit.SPADES,Rank.ACE));
		Assert.assertEquals(false,game.checkBlackJack(player));
		player.add(new Card(Suit.SPADES,Rank.EIGHT));
		player.add(new Card(Suit.SPADES,Rank.TWO));
		Assert.assertEquals(false,game.checkBlackJack(player));
		player.add(new Card(Suit.SPADES,Rank.TWO));
		Assert.assertEquals(false,game.checkBlackJack(player));
	}

	@Test
	public void checkPlayerBlackJack() throws Exception {
		game = new Game(deck,out,in);
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.ACE));
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.QUEEN));
		game.dealtCardToPlayer();
		game.dealtCardToPlayer();
		Assert.assertEquals(true,game.checkPlayerBlackJack());

	}

	@Test
	public void initialDealing() throws Exception {
		game = new Game(deck,out,in);
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.ACE));
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.QUEEN));
		deck.pushCardInTop(new Card(Suit.SPADES,Rank.KING));
		game.initialDealing();
		Assert.assertEquals(2,game.getPlayerCards().size());
		Assert.assertEquals(1,game.getDealerCards().size());
	}



	public byte[] prepareInputMockByte(String string){
		return string.getBytes();
	}

}