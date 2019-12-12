package exercise3;

import java.util.Comparator;

public class StudentMeritComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		Double m1 = s1.calculateMarkAverage();
		Double m2 = s2.calculateMarkAverage();
		return m2.compareTo(m1);
	}

}
