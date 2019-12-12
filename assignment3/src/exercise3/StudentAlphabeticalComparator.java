package exercise3;

import java.util.Comparator;

public class StudentAlphabeticalComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		String n1 = s1.getName();
		String n2 = s2.getName();
		return n1.compareTo(n2);
	}

}
