package exercise1;

import java.util.Arrays;

public class Exercise1 {

	public static void main(String[] args) {
		String [] array = new String[] {"banana", "apples", "grape", "strawberries", "tangerine", "echo", "oranges", "ear", "eggs"};

		System.out.println("Order by smallest to largest based on length:");
		Arrays.sort(array, (s1, s2) -> {return ((Integer)s1.length()).compareTo(s2.length());});
		System.out.println(Arrays.toString(array));

		System.out.println("\nOrder by largest to smallest based on length :");
		Arrays.sort(array, (s1, s2) -> {return ((Integer)s2.length()).compareTo(s1.length());});
		System.out.println(Arrays.toString(array));

		System.out.println("\nOrder by smallest to largest based on alphabetical first letter:");
		Arrays.sort(array, (s1, s2) -> {return ((Character)s1.charAt(0)).compareTo(s2.charAt(0));});
		System.out.println(Arrays.toString(array));

		System.out.println("\nOrder by words that start with e first and all others after:");
		Arrays.sort(array, (s1, s2) -> {
			if (s1.charAt(0) == 'e' && s2.charAt(0) == 'e') {
				return 0;
			} else if (s1.charAt(0) == 'e') {
				return -1;
			} else {
				return 1;
			}
		});
		System.out.println(Arrays.toString(array));

		System.out.println("\nOrder by words that start with e first and all others after with helper:");
		Arrays.sort(array, (s1, s2) -> Utils.sortByWordsStartingWithEHelper(s1, s2));
		System.out.println(Arrays.toString(array));
	}

}
