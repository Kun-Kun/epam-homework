package ua.epam.homework.strings;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class First {

	public static List<String> sortByFrequencyCaseSensitive(List<String> listToSort, String text){
		Map<String,Integer> wordFrequencyMap = listToSort
				.stream()
				.collect(Collectors.toMap(key -> key,val -> 0 ));
		Pattern pattern = Pattern.compile("[a-zA-zА-Яа-я'іІїЇёЁ]+");
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()){
			String word = matcher.group();
			Integer count = wordFrequencyMap.get(word);
			if (count!=null){
				count++;
				wordFrequencyMap.put(word,count);
			}
		}
		return wordFrequencyMap
				.entrySet()
				.stream()
				.sorted((o1, o2) -> Integer.compare(o2.getValue(),o1.getValue()))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}

	public static List<String> sortByFrequency(List<String> listToSort, String text){
		String lowerCaseText = text.toLowerCase();
		Map<String,String> lowerCaseToInputMap = listToSort
				.stream()
				.collect(Collectors.toMap(key -> key.toLowerCase(),key->key ));
		List<String> lowerCaseInputList = new ArrayList<>(lowerCaseToInputMap.keySet());
		List<String> lowerCaseOutputList = sortByFrequencyCaseSensitive(lowerCaseInputList,lowerCaseText);

		return lowerCaseOutputList
				.stream()
				.map(s -> lowerCaseToInputMap.get(s))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		String text = "Равным образом рамки и место обучения кадров влечет за собой процесс внедрения и модернизации дальнейших направлений развития. Не следует, однако забывать, что постоянный количественный рост и сфера нашей активности требуют определения и уточнения позиций, занимаемых участниками в отношении поставленных задач. Равным образом постоянное информационно-пропагандистское обеспечение нашей деятельности играет важную роль в формировании модели развития. Значимость этих проблем настолько очевидна, что постоянное информационно-пропагандистское обеспечение нашей деятельности обеспечивает широкому кругу (специалистов) участие в формировании дальнейших направлений развития. С другой стороны новая модель организационной деятельности играет важную роль в формировании системы обучения кадров, соответствует насущным потребностям. Таким образом сложившаяся структура организации требуют определения и уточнения существенных финансовых и административных условий.";
		List<String> list = new ArrayList<>();
		list.add("Образом");
		list.add("процесс");
		list.add("кадров");
		List<String> sortedList = First.sortByFrequency(list,text);
		for (String string:sortedList){
			System.out.println(string);
		}
	}


}
