package ua.epam.homework.first.twentyone;

public enum Rank {
	ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
	public int calculateRankPower(){
		if (this.equals(Rank.ACE)){
			return 13;
		}else {
			return this.ordinal();
		}
	}
}
