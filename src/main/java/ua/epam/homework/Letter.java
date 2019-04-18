package ua.epam.homework;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Letter {

	private Integer  attempts = 0;
	private Character  secretCharacter;
	public static void main(String[] args) {
		Letter letter = new Letter();
		letter.playGame();

	}

	private Character userCharacterRead(){
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Guess a char: ");
		try {
			String inputString = inputScanner.next("[a-zA-z]");
			return inputString.toLowerCase().charAt(0);
		}catch (InputMismatchException exception){
			System.out.println("You can type only one char (a-z or A-z)");
			return userCharacterRead();
		}

	}

	private boolean isLetterRight(Character userInput){
		if(userInput.equals(secretCharacter)){
			return true;
		}
		else {
			giveHint(userInput);
			return false;
		}
	}

	private void giveHint(Character userInput){
		if(userInput.compareTo(secretCharacter)>0){
			System.out.println("Too low");
		}else{
			System.out.println("Too high");
		}

	}

	public void playGame(){
		initGame();
		Character userInput;
		do {
			userInput = userCharacterRead();
			attempts++;
		}while(isLetterRight(userInput)==false);
		System.out.println("You win!");
		System.out.println("User attempts: "+ attempts);
	}

	private void initGame(){
		String chars = "qwertyuiopasdfghjklzxcvbnm";
		Random rnd = new Random();
		secretCharacter = chars.charAt(rnd.nextInt(chars.length()));
	}

}
