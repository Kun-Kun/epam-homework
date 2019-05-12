package ua.epam.homework.strings;

import org.junit.Assert;
import org.junit.Test;

public class ThirdTest {
	@Test
	public void findLongestPalindrome() throws Exception {
		String text = "Able was I ere I saw elbA\nSator arepo tenet opera rotaS\nThe sower Arepo holds with effort the wheels";
		String expected = "Sator arepo tenet opera rotaS";
		String result = ThirdTask.findLongestPalindrome(text);
		Assert.assertEquals(expected,result);
	}

	@Test
	public void findLongestPalindromeNoPalindrome() throws Exception {
		String text = "The sower Arepo holds with effort the wheels";
		String expected = null;
		String result = ThirdTask.findLongestPalindrome(text);
		Assert.assertEquals(expected,result);
	}

	@Test(expected = NullPointerException.class)
	public void findLongestPalindromeNull() throws Exception {
		ThirdTask.findLongestPalindrome(null);
	}

}