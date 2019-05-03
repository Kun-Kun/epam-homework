package ua.epam.homework.first.twentyone;

import ua.epam.homework.first.tools.GameTools;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		deck = new LinkedList<>();
	}

	public Deck(List<Card> deck) {
		this.deck = deck;
	}

	public static Deck createClassical(){
		Deck deck = new Deck();
		deck.addFullDeck();
		deck.shuffle();
		return deck;
	}

	public void shuffle(){
		Collections.shuffle(deck);
	}

	public void addFullDeck(){
		for (Suit suit: Suit.values()){
			for(Rank rank: Rank.values()){
				deck.add(new Card(suit,rank));
			}
		}
	}

	public Card popTopCard(){
		if (deck.size()>0) {
			return deck.remove(deck.size() - 1);
		}
		return null;
	}

	public Card popRandomCard(){
		if (deck.size()>0) {
			return deck.remove(GameTools.randomInt(deck.size()));
		}
		return null;
	}

	public void pushCardInRandom(Card card){
		deck.add(GameTools.randomInt(deck.size()),card);
	}

	public void pushCardInTop(Card card){
		deck.add(card);
	}

	public boolean isEmpty(){
		return deck.isEmpty();
	}

	public List<Card> getCardList(){
		return new LinkedList<>(deck);
	}

	public static Deck merge(Deck deck1, Deck deck2){
		List<Card> cardList = deck1.getCardList();
		cardList.addAll(deck2.getCardList());
		return new Deck(cardList);
	}

	public void addFullDecks(int count){
		for (int i = 0; i <count ; i++) {
			addFullDeck();
		}
	}

	public void clearDeck(){
		deck.clear();
	}

	public int getCardsCount(){
		return deck.size();
	}

}
