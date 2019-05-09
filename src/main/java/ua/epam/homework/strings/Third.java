package ua.epam.homework.strings;

import java.util.Arrays;

public class Third {
	public static String findLongestPalindrome(String text){
		return Arrays.stream(text.replaceAll("\r","").split("\n")).filter(s -> {
			String reversed = new StringBuilder(s).reverse().toString();
			return reversed.equals(s);
		}).sorted((o1, o2) -> o2.length() - o1.length()).findFirst().orElse(null);
	}

	public static void main(String[] args) {
		String text = "Able was I ere I saw elbA\nSator arepo tenet opera rotaS\nThe sower Arepo holds with effort the wheels";
		System.out.println(findLongestPalindrome(text));
	}
}
