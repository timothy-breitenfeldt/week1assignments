package exercise3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise3 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("hello", "and", "abc", "abcd", "the", "world", "ant");
		List<String> result = filterWords(list);
		System.out.println(result);
	}

	private static List<String> filterWords(List<String> list) {
		return list.stream().filter((word) -> word.length() == 3)
				.filter(word -> word.charAt(0) == 'a')
				.collect(Collectors.toList());
	}

}
