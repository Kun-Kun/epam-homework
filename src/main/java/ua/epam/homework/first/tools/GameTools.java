package ua.epam.homework.first.tools;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class GameTools {
	public static Character randomChar(String chars){
		return chars.charAt(chars.length());
	}

	public static int randomInt(int to){
		Random rnd = new Random();
		return rnd.nextInt(to);
	}

	public static Character readChar(PrintStream printStream, Scanner inputScanner, String pattern){
		String inputString = inputScanner.nextLine();
		if(inputString.matches(pattern)) {
			return inputString.charAt(0);
		}else {
			printStream.println("You can type only one char " + pattern);
			return readChar(printStream, inputScanner, pattern);
		}

	}
}
