package ua.epam.homework.tools;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

import static org.junit.Assert.*;

public class GameToolsTest {
	@Test
	public void randomCharCoverage() throws Exception {

		String charSet = "qwerty";
		Set generated = new HashSet();
		for (int i = 0; i <1000 ; i++) {
			generated.add(GameTools.randomChar(charSet));
		}
		Assert.assertEquals(charSet.length(),generated.size());

	}

	@Test
	public void readChar() throws Exception {
		OutputStream outputStream = new ByteArrayOutputStream();
		Scanner inputScanner = new Scanner(new ByteArrayInputStream("a".getBytes()));
		PrintStream printStream = new PrintStream(outputStream);
		Assert.assertEquals((Character)'a',GameTools.readChar(printStream,inputScanner,"[a]"));
	}

	@Test(expected = NoSuchElementException.class)
	public void readCharWrongPattern() throws Exception {
		OutputStream outputStream = new ByteArrayOutputStream();
		Scanner inputScanner = new Scanner(new ByteArrayInputStream("a".getBytes()));
		PrintStream printStream = new PrintStream(outputStream);
		Assert.assertEquals((Character)'a',GameTools.readChar(printStream,inputScanner,"[b]"));
	}

	@Test
	public void readCharWrongRightPattern() throws Exception {
		OutputStream outputStream = new ByteArrayOutputStream();
		Scanner inputScanner = new Scanner(new ByteArrayInputStream("b\na\n".getBytes()));
		PrintStream printStream = new PrintStream(outputStream);
		Assert.assertEquals((Character)'a',GameTools.readChar(printStream,inputScanner,"[a]"));
	}


}