package ua.epam.homework;

import java.util.Arrays;

public class MostCommonSymbol {

	public static char findMostCommon(String text){
		char[] characters = text.toCharArray();
		int size = characters.length;
		char mostCommon = Character.MAX_VALUE;
		int mostCommonCount = 0;
		char current;
		while(size>0) {
			int writePoint = 0;
			current = characters[0];
			int currentCount=0;
			for (int readPoint = 0; readPoint < size; readPoint++) {
				if(current == characters[readPoint]){
					currentCount++;
				}else {
					characters[writePoint]=characters[readPoint];
					writePoint++;
				}

			}
			if (currentCount>mostCommonCount){
				mostCommon = current;
				mostCommonCount = currentCount;
			}
			characters = Arrays.copyOf(characters,writePoint);
			size = characters.length;
		}

		return mostCommon;
	}


	public static void main(String[] args) {
		System.out.println(findMostCommon("Lorem ipsum dolor sit amet,consectetuer adipiscing elit"));
	}
}
