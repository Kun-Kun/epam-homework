package ua.epam.homework.twentyone;

import ua.epam.homework.tools.GameTools;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {

	private Deck deck ;

	private PrintStream printStream;
	private Scanner inputScanner;

	private List<Card> dealer = new ArrayList<>();
	private List<Card> player = new ArrayList<>();

	public Game(Deck deck, PrintStream printStream, InputStream inputStream) {
		this.deck = deck;
		this.printStream = printStream;
		this.inputScanner = new Scanner(inputStream);
	}

	public Game() {
		this(Deck.createClassical(),System.out,System.in);
	}

	private Card dealtCard(List<Card> destination){
		Card card = deck.popTopCard();
		printStream.println(card);
		destination.add(card);
		return card;
	}
	public Card dealtCardToDealer(){
		printStream.println("Dealing card to dealer:");
		return dealtCard(dealer);
	}

	public Card dealtCardToPlayer(){
		printStream.println("Dealing card to player:");
		return dealtCard(player);
	}

	public int calculateDealerPoints(){
		return calculatePoints(dealer);
	}

	public int calculatePlayerPoints(){
		return calculatePoints(player);
	}

	public int calculatePoints(List<Card> combination){
		List<Card> sortedCombination = new ArrayList<>(combination);
		Collections.sort(sortedCombination);
		int sum = 0;
		for (Card card: sortedCombination ) {
			sum+= calculatePoints(sum,card);
		}
		return sum;
	}

	public int calculatePoints(int currentPoint, Card card){
		switch (card.getRank()){
			case ACE:
				if(currentPoint>10){
					return 1;
				}else {
					return 11;
				}
			case JACK:
			case QUEEN:
			case KING:
				return 10;
			default:
				return card.getRank().ordinal()+1;
		}
	}

	protected Character readUserChar(){
		printStream.println("Type 'a' (ahead dealing) or 's' (stop)");
		return GameTools.readChar(printStream,inputScanner,"[as]");
	}

	public boolean checkOverdeal(List<Card> cards){
		return calculatePoints(cards)>21;
	}

	public void printPoints(){
		printStream.print("Dealer : ");
		printStream.println(calculateDealerPoints());

		printStream.print("Player : ");
		printStream.println(calculatePlayerPoints());
	}

	public void dealtCardsToDealer(int score){
		while(calculateDealerPoints()<score){
			dealtCardToDealer();
			printPoints();
			if (checkOverdeal(dealer)){
				printStream.println("Dealer got too much and you win" );
				System.exit(0);
			}
		}
	}

	public void dealtCardsToPlayer(){
		Character character = readUserChar();
		while (character.equals('a')){
			dealtCardToPlayer();
			printPoints();
			if (checkOverdeal(player)){
				printStream.println("You've got too much and you lose" );
				System.exit(0);
			}
			character = readUserChar();
		}
	}

	public void announceWinner(){
		int dealerScore = calculateDealerPoints();
		int playerScore = calculatePlayerPoints();
		if (dealerScore>playerScore){
			printStream.print("You lose");
		}else if(dealerScore<playerScore){
			printStream.print("You win");
		}else{
			printStream.print("Friendship won :)");
		}
	}

	public boolean checkBlackJack(List<Card> cards){
		return cards.size()==2&&calculatePoints(cards)==21;
	}

	public boolean checkPlayerBlackJack(){
		return checkBlackJack(player);
	}

	public void initialDealing(){
		dealtCardToDealer();
		dealtCardToPlayer();
		dealtCardToPlayer();
	}

	public void start(){
		initialDealing();
		printPoints();
		if (checkPlayerBlackJack()){
			if(calculateDealerPoints()<10){
				printStream.println("Blackjack! You win");
				System.exit(0);
			}else {
				dealtCardToDealer();
				printPoints();
				announceWinner();
				System.exit(0);
			}
		}

		dealtCardsToPlayer();
		dealtCardsToDealer(17);

		announceWinner();

	}

	public static void main(String[] args) {
		Game game = new Game();

		game.start();


	}


}
