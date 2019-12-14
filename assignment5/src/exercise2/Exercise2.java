package exercise2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<? extends Object> list = nums.stream().map(x -> convertIntegerToStringHelper(x)).collect(Collectors.toList());
		String result = String.join(",",  (List<String>)list);
		System.out.println(result);
	}

	private static Object convertIntegerToStringHelper(int x) {
		boolean isEven = (x% 2 == 0);
		String str = String.valueOf(x);
		
		if (isEven) {
			str = "e" + str;
		} else {
			str = "o" + str;
		}
		
		return str;
	}

}
