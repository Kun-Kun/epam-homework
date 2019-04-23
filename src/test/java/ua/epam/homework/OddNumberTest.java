package ua.epam.homework;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OddNumberTest {
	@Test
	public void findOddNumber() throws Exception {
		int[] numbers ={-221,-1,1,15,16};
		Assert.assertEquals(15,OddNumber.findOddNumber(numbers));
	}

}