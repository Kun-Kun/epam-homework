package ua.epam.homework.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Second {
	public static String sortWordByChar(String text, char charr){
		return Arrays.stream(text.split(" ")).sorted(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1!=null&&o2!=null) {
					return countChar(o2) - countChar(o1);
				}

				return 0;
			}

			private int countChar(String word){
				return (int)word.chars().filter(value -> (char)value == charr).count();
			}

		}.thenComparing(Comparator.comparing(String::toString))).collect( Collectors.joining( " " ) );
	}

	public static void main(String[] args) {
		String text = "С другой стороны рамки и место обучения кадров представляет собой интересный эксперимент проверки форм развития. Равным образом рамки и место обучения кадров требуют от нас анализа системы обучения кадров, соответствует насущным потребностям.";
		System.out.println(sortWordByChar(text,'а'));
	}
}
