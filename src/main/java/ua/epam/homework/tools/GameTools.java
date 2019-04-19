package ua.epam.homework.tools;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class GameTools {
	public static Character randomChar(String chars){
		Random rnd = new Random();
		return chars.charAt(rnd.nextInt(chars.length()));
	}

	public static Character readChar(PrintStream printStream, Scanner inputScanner, String pattern){
		printStream.print("Guess a char: ");
		String inputString = inputScanner.nextLine();
		if(inputString.matches(pattern)) {
			return inputString.charAt(0);
		}else {
			printStream.println("You can type only one char " + pattern);
			return readChar(printStream, inputScanner, pattern);
		}

	}
}
