package ua.epam.homework;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.epam.homework.first.Letter;

import java.io.*;
import java.util.*;

public class LetterTest {

	private Letter letter;
	private PrintStream out;
	private InputStream in;
	private ByteArrayOutputStream outputStream;

	@Before
	public void initGame(){
		in = new ByteArrayInputStream(prepareInputMockByte(""));
		outputStream = new ByteArrayOutputStream();
		out = new PrintStream(outputStream);

	}

	@Test
	public void prepareCharacterToLowercase() throws Exception {
		letter = new Letter('a',"[b]",out,in);
		Assert.assertEquals((Character) 'a', letter.prepareCharacter('A'));
	}

	@Test
	public void readRightUserChar() {
		in = new ByteArrayInputStream(prepareInputMockByte("b\n"));
		letter = new Letter('a',"[b]",out,in);
		Assert.assertEquals((Character) 'b', letter.readUserChar("[b]"));
	}

	@Test(expected = NoSuchElementException.class)
	public void readWrongPatternUserChar(){
		in = new ByteArrayInputStream(prepareInputMockByte("a\n"));
		letter = new Letter('a',"[b]",out,in);
		letter.readUserChar("[b]");
	}

	@Test(expected = NoSuchElementException.class)
	public void readMoreThanOneRightUserChar() {
		in = new ByteArrayInputStream(prepareInputMockByte("bb\n"));
		letter = new Letter('a',"[b]",out,in);
		Assert.assertEquals((Character) 'b', letter.readUserChar("[b]"));
	}


	@Test
	public void giveHintTooLow() throws Exception {
		letter = new Letter('b',"[b]",out,in);
		letter.giveHint('c');
		Assert.assertEquals("Too low\r\n", outputStream.toString("utf-8"));
	}

	@Test
	public void giveHintTooHigh() throws Exception {
		letter = new Letter('b',"[b]",out,in);
		letter.giveHint('a');
		Assert.assertEquals("Too high\r\n", outputStream.toString("utf-8"));
	}



	@Test
	public void playFullGame() throws Exception {
		in = new ByteArrayInputStream(prepareInputMockByte("a\nc\nas\nd\nb\n"));
		letter = new Letter('b',"[a-cA-C]",out,in);
		letter.playGame();
		Assert.assertEquals("Guess a char: Too high\r\n" +
				"Guess a char: Too low\r\n" +
				"Guess a char: You can type only one char [a-cA-C]\r\n" +
				"Guess a char: You can type only one char [a-cA-C]\r\n" +
				"Guess a char: You win!\r\n" +
				"Attempts: 3\r\n",outputStream.toString("utf-8"));
	}

	@Test
	public void playWinGame() throws Exception {
		in = new ByteArrayInputStream(prepareInputMockByte("b\n"));
		letter = new Letter('b',"[a-cA-C]",out,in);
		letter.playGame();
		Assert.assertEquals("Guess a char: You win!\r\n" +
				"Attempts: 1\r\n",outputStream.toString("utf-8"));
	}

	@Test
	public void playWrongHighRightGame() throws Exception {
		in = new ByteArrayInputStream(prepareInputMockByte("a\nb\n"));
		letter = new Letter('b',"[a-cA-C]",out,in);
		letter.playGame();
		Assert.assertEquals("Guess a char: Too high\r\n" +
				"Guess a char: You win!\r\n" +
				"Attempts: 2\r\n",outputStream.toString("utf-8"));
	}

	@Test
	public void playMoreThanOneInputThenWinGame() throws Exception {
		in = new ByteArrayInputStream(prepareInputMockByte("aa\nb\n"));
		letter = new Letter('b',"[a-cA-C]",out,in);
		letter.playGame();
		Assert.assertEquals("Guess a char: You can type only one char [a-cA-C]\r\n" +
				"Guess a char: You win!\r\n" +
				"Attempts: 1\r\n",outputStream.toString("utf-8"));
	}

	@Test
	public void playWrongInputThenWinGame() throws Exception {
		in = new ByteArrayInputStream(prepareInputMockByte("e\nb\n"));
		letter = new Letter('b',"[a-cA-C]",out,in);
		letter.playGame();
		Assert.assertEquals("Guess a char: You can type only one char [a-cA-C]\r\n" +
				"Guess a char: You win!\r\n" +
				"Attempts: 1\r\n",outputStream.toString("utf-8"));
	}

	@Test
	public void playWrongLowThenRightGame() throws Exception {
		in = new ByteArrayInputStream(prepareInputMockByte("c\nb\n"));
		letter = new Letter('b',"[a-cA-C]",out,in);
		letter.playGame();
		Assert.assertEquals("Guess a char: Too low\r\n" +
				"Guess a char: You win!\r\n" +
				"Attempts: 2\r\n",outputStream.toString("utf-8"));
	}

	@Test
	public void playRightUpperCaseGame() throws Exception {
		in = new ByteArrayInputStream(prepareInputMockByte("B\n"));
		letter = new Letter('b',"[a-cA-C]",out,in);
		letter.playGame();
		Assert.assertEquals("Guess a char: You win!\r\n" +
				"Attempts: 1\r\n",outputStream.toString("utf-8"));
	}


	public byte[] prepareInputMockByte(String string){
		return string.getBytes();
	}

}