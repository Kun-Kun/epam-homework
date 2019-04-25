package ua.epam.homework.twentyone;

import ua.epam.homework.tools.GameTools;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {

	private Deck deck ;

	private PrintStream printStream;
	private Scanner inputScanner;

	private List<Card> dealerCards = new ArrayList<>();
	private List<Card> playerCards = new ArrayList<>();

	public Game(Deck deck, PrintStream printStream, InputStream inputStream) {
		this.deck = deck;
		this.printStream = printStream;
		this.inputScanner = new Scanner(inputStream);
	}

	public Game() {
		this(Deck.createClassical(),System.out,System.in);
	}

	protected List<Card> getDealerCards() {
		return dealerCards;
	}

	protected List<Card> getPlayerCards() {
		return playerCards;
	}

	protected Card dealtCard(List<Card> destination){
		Card card = deck.popTopCard();
		printStream.println(card);
		destination.add(card);
		return card;
	}
	protected Card dealtCardToDealer(){
		printStream.println("Dealing card to dealer:");
		return dealtCard(dealerCards);
	}

	protected Card dealtCardToPlayer(){
		printStream.println("Dealing card to player:");
		return dealtCard(playerCards);
	}

	protected int calculateDealerPoints(){
		return calculatePoints(dealerCards);
	}

	protected int calculatePlayerPoints(){
		return calculatePoints(playerCards);
	}

	protected int calculatePoints(List<Card> combination){
		List<Integer> points = new ArrayList<>();
		for (Card card: combination ) {
			points = calculatePoints(points,card);

		}
		return getPointLessThanBlackjackOrMin(points);
	}

	protected List<Integer> calculatePoints(List<Integer> currentPoints, Card card){
		if (currentPoints==null){
			currentPoints = new ArrayList<>();
		}

		switch (card.getRank()){
			case ACE:
				List<Integer> forEleven = addPoints(currentPoints,11);
				List<Integer> forOneResult = addPoints(currentPoints,1);
				forOneResult.addAll(forEleven);
				return forOneResult;
			case JACK:
			case QUEEN:
			case KING:
				return addPoints(currentPoints,10);
			default:
				return addPoints(currentPoints,card.getRank().ordinal()+1);
		}
	}

	protected List<Integer> filterPointsBigger21(List<Integer> points){
		return points.stream().filter(integer -> integer<=21).collect(Collectors.toList());
	}

	protected Integer getPointLessThanBlackjackOrMin(List<Integer> currentPoints){
		List<Integer> filteredPoints = filterPointsBigger21(currentPoints);
		if (filteredPoints.size()>0){
			return filteredPoints.stream().mapToInt(v -> v).max().orElse(0);
		}else {
			return currentPoints.stream().mapToInt(v -> v).min().orElse(0);
		}
	}


	protected List<Integer> addPoints(List<Integer> currentPoints,int points){
		List<Integer> resultPoints = new ArrayList<>(currentPoints);
		if (resultPoints.isEmpty()){
			resultPoints.add(points);
			return resultPoints;
		}else {
			return resultPoints.stream().map((point)->point+points).collect(Collectors.toList());
		}
	}


	protected Character readUserChar(){
		printStream.println("Type 'a' (ahead dealing) or 's' (stop)");
		return GameTools.readChar(printStream,inputScanner,"[as]");
	}

	protected boolean checkOverdeal(List<Card> cards){
		return calculatePoints(cards)>21;
	}

	protected void printPoints(){
		printStream.print("Dealer : ");
		printStream.println(calculateDealerPoints());

		printStream.print("Player : ");
		printStream.println(calculatePlayerPoints());
	}

	protected void dealtCardsToDealer(int score){
		while(calculateDealerPoints()<score){
			dealtCardToDealer();
			printPoints();
			if (checkOverdeal(dealerCards)){
				printStream.println("Dealer got too much and you win" );
				System.exit(0);
			}
		}
	}

	protected void dealtCardsToPlayer(){
		Character character = readUserChar();
		while (character.equals('a')){
			dealtCardToPlayer();
			printPoints();
			if (checkOverdeal(playerCards)){
				printStream.println("You've got too much and you lose" );
				System.exit(0);
			}
			character = readUserChar();
		}
	}

	protected void announceWinner(){
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

	protected boolean checkBlackJack(List<Card> cards){
		return cards.size()==2&&calculatePoints(cards)==21;
	}

	protected boolean checkPlayerBlackJack(){
		return checkBlackJack(playerCards);
	}

	protected void initialDealing(){
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
