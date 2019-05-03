package ua.epam.homework.first.twentyone;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.contains;


public class DeckTest {
	@Test
	public void createClassical() throws Exception {
		Deck deck = Deck.createClassical();
		Assert.assertEquals(52,deck.getCardsCount());
	}

	@Test
	public void shuffle() throws Exception {
		Deck deckOne = new Deck();
		deckOne.addFullDeck();
		Deck deckTwo = new Deck();
		deckTwo.addFullDeck();

		Assert.assertThat(deckOne.getCardList(), is(deckTwo.getCardList()));
		deckTwo.shuffle();
		Assert.assertThat(deckOne.getCardList(), is(not(deckTwo.getCardList())));

	}

	@Test
	public void addFullDeck() throws Exception {
		Deck deckOne = new Deck();
		deckOne.addFullDeck();
		Assert.assertThat(deckOne.getCardsCount(),is(new HashSet<>(deckOne.getCardList()).size()));

	}

	@Test
	public void popTopCard() throws Exception {
		Deck deck = new Deck();
		Card card = new Card(Suit.CLUBS,Rank.ACE);
		deck.pushCardInTop(new Card(Suit.CLUBS,Rank.FOUR));
		deck.pushCardInTop(card);
		Assert.assertEquals(deck.popTopCard(),card);
	}

	@Test
	public void pushCardInTop() throws Exception {
		Deck deck = new Deck();
		Card card = new Card(Suit.CLUBS,Rank.ACE);
		deck.pushCardInTop(new Card(Suit.CLUBS,Rank.FOUR));
		deck.pushCardInTop(card);
		List cards = deck.getCardList();
		Assert.assertEquals(cards.get(cards.size()-1),card);
	}

	@Test
	public void isEmpty() throws Exception {
		Deck deck = new Deck();
		Card card = new Card(Suit.CLUBS,Rank.ACE);
		Assert.assertEquals(true,deck.isEmpty());
		deck.pushCardInTop(card);
		Assert.assertEquals(false,deck.isEmpty());

	}

	@Test
	public void getCardList() throws Exception {
		Deck deck = new Deck();
		Card card = new Card(Suit.CLUBS,Rank.ACE);
		deck.pushCardInTop(card);
		Assert.assertThat(deck.getCardList(),contains(card));
	}

	@Test
	public void merge() throws Exception {
		Deck deckOne = new Deck();
		deckOne.addFullDeck();
		Deck deckTwo = new Deck();
		deckTwo.addFullDeck();
		Deck result = Deck.merge(deckOne,deckTwo);
		Assert.assertEquals(result.getCardsCount(),deckOne.getCardsCount()+deckTwo.getCardsCount());
	}

	@Test
	public void addFullDecks() throws Exception {
		Deck deck = new Deck();
		deck.addFullDecks(2);
		Assert.assertEquals(104,deck.getCardsCount());

	}

	@Test
	public void clearDeck() throws Exception {
		Deck deck = new Deck();
		deck.pushCardInTop(new Card(Suit.CLUBS,Rank.ACE));
		deck.pushCardInTop(new Card(Suit.DIAMONDS,Rank.FOUR));
		Assert.assertEquals(2,deck.getCardsCount());
		deck.clearDeck();
		Assert.assertEquals(0,deck.getCardsCount());
	}

	@Test
	public void getCardsCount() throws Exception {
		Deck deck = new Deck();
		deck.pushCardInTop(new Card(Suit.CLUBS,Rank.ACE));
		Assert.assertEquals(1,deck.getCardsCount());
		deck.pushCardInTop(new Card(Suit.DIAMONDS,Rank.FOUR));
		Assert.assertEquals(2,deck.getCardsCount());
	}

}