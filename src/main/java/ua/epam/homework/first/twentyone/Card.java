package ua.epam.homework.first.twentyone;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Card)) return false;

		Card card = (Card) o;

		if (suit != card.suit) return false;
		return getRank() == card.getRank();
	}

	@Override
	public int hashCode() {
		int result = suit.hashCode();
		result = 31 * result + getRank().hashCode();
		return result;
	}
}
