package exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Exercise2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		ListIterator<String> iterator = null;

		list.add("pear");
		list.add("banana");
		list.add("tangerine");
		list.add("strawberry");
		list.add("blackberry");

		System.out.println("Print with iterator.");
		for (String fruit : list) {
			System.out.println(fruit);
		}
		System.out.println();

			iterator = list.listIterator(list.size());
			System.out.println("iterator reverse order:");
			while (iterator.hasPrevious()) {
				System.out.println(iterator.previous());
			}
			System.out.println();
			
			list.add(3, "banana");
			System.out.println("added banana at index 3.");
			for (String fruit : list) {
				System.out.println(fruit);
			}
	}

}
