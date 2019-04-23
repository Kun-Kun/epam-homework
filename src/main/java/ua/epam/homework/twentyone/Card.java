package ua.epam.homework.twentyone;

public class Card implements Comparable<Card>{
	private final Suit suit;
	private final Rank rank;

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public Rank getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return  rank+" of "+suit ;
	}

	@Override
	public int compareTo(Card obj) {
		if (obj == null) return 1;
		Integer thisValue = rank.calculateRankPower();
		Integer objValue = obj.getRank().calculateRankPower();
		return 	thisValue - objValue;

	}


}
