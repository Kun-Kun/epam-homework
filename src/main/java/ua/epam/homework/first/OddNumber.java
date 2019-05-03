package ua.epam.homework.first;

public class OddNumber {
	
	public static int findOddNumber(int[] numbers){
		int highest = Integer.MIN_VALUE;
		for (int number: numbers){
			if (number%2==1&&number>highest){
				highest=number;
			}
		}
		return highest;
	}

}
