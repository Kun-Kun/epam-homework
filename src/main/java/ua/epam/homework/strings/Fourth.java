package ua.epam.homework.strings;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fourth {
	public static String replaceWordLengthWith(int length,String inputText, String replace){
		Pattern pattern = Pattern.compile("^([a-zA-zА-Яа-я'іІїЇёЁ]{"+length+"})([ ,.;:?!])|([ ,.;:?!])([a-zA-zА-Яа-я'іІїЇёЁ]{"+length+"})([ ,.;:?!])|([ ,.;:?!])([a-zA-zА-Яа-я'іІїЇёЁ]{"+length+"})$");
		Matcher matcher = pattern.matcher(inputText);
		if (matcher.find()){
			return matcher.replaceAll("$3$6"+replace+"$2$5");
		}
		return inputText;
	}

	public static void main(String[] args) {
		String text = "Задача организации, в особенности же дальнейшее развитие различных форм деятельности позволяет выполнять важные задания по разработке соответствующий условий активизации. ";
		System.out.println(replaceWordLengthWith(11,text,"ВАСИЛИЙ"));
	}
}
