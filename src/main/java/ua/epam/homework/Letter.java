package ua.epam.homework;

import ua.epam.homework.tools.GameTools;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Letter {

	private final Character secretCharacter;
	private final String verifyingPattern;

	private PrintStream printStream;
	private Scanner inputScanner;

	private Integer attempts = 0;

	public static void main(String[] args) {
		Letter letter = new Letter();
		letter.playGame();
	}

	public Letter() {
		this(GameTools.randomChar("qwertyuiopasdfghjklzxcvbnm"),"[a-zA-z]",System.out,System.in);
	}

	public Letter(Character secretCharacter,String verifyingPattern, PrintStream printStream, InputStream inputStream) {
		this.verifyingPattern = verifyingPattern;
		this.secretCharacter = prepareCharacter(secretCharacter);
		this.printStream = printStream;
		inputScanner = new Scanner(inputStream);
	}

	protected Character prepareCharacter(Character character){
		return Character.toLowerCase(character);
	}


	protected Character readUserChar(String pattern){
		printStream.print("Guess a char: ");
		Character userInput = GameTools.readChar(printStream,inputScanner,pattern);
		return prepareCharacter(userInput);
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

	protected void giveHint(Character userInput){
		if(userInput.compareTo(secretCharacter)>0){
			printStream.println("Too low");
		}else if(userInput.compareTo(secretCharacter)<0){
			printStream.println("Too high");
		}
	}

	public void playGame(){
		Character userInput;
		do {
			userInput = readUserChar(verifyingPattern);
			attempts++;
		}while(!isLetterRight(userInput));
		printStream.println("You win!");
		printStream.println("Attempts: "+ attempts);
	}

}
