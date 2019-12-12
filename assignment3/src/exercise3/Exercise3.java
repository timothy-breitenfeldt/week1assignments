package exercise3;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) throws FileNotFoundException {
		File fo = new File("exercise3Students.txt");
		Scanner fin = new Scanner(fo);
		HashMap<String, Student> studentMap = new HashMap<>();
		Student student = null;
		Student previousStudent = null;
		List<Student> studentList = null;
		NumberFormat formatter = new DecimalFormat("#0.0");
		int rank = 0;
		double averageStudentMark = 0.0;
		double standardDeviation = 0.0;
		
		while (fin.hasNextLine()) {
			String line = fin.nextLine();
			String[] lineArray = line.split(" ");
			String name = lineArray[0].trim();
			int mark = Integer.parseInt(lineArray[1]);
			
			if (studentMap.containsKey(name)) {
				student = studentMap.get(name);
				student.addMark(mark);
			} else {
				student = new Student(name, mark);
				studentMap.put(name, student);
			}
		}
		
		fin.close();
		studentList = new ArrayList<Student>(studentMap.values());
		
		System.out.println("Alphabetical order");
		studentList.sort(new StudentAlphabeticalComparator());
		for (Student s : studentList) {
			System.out.println(s.getName() + " " + s.getMarks().size() + " " + formatter.format(s.calculateMarkAverage()));
		}
		System.out.println();
		
		System.out.println("Merit order");
		previousStudent = studentList.get(0);
		studentList.sort(new StudentMeritComparator());
		for (Student s : studentList) {
			if (s.calculateMarkAverage() != previousStudent.calculateMarkAverage()) {
				rank++;
			}
			
			System.out.println(rank + " " + s.getName() + " " + s.getMarks().size() + " " + formatter.format(s.calculateMarkAverage()));
			previousStudent = s;
		}
		System.out.println();

		averageStudentMark = calculateAverageStudentMark(studentList);
		standardDeviation = calculateStandardDeviation(studentList, averageStudentMark);
			System.out.println("Number of students: " + studentList.size());
			System.out.println("Average student mark: " + formatter.format(averageStudentMark));
			System.out.println("Standard deviation: " + formatter.format(standardDeviation));
	}
	
	private static double calculateAverageStudentMark(List<Student> students) {
		double average = 0.0;
		
		for (Student s : students) {
			average += s.calculateMarkAverage();
		}
		
		average /= students.size();
		return average;
	}
	
	private static double calculateStandardDeviation(List<Student> students, double mean) {
		double standardDeviation = 0.0;
		
		for (Student s : students) {
			standardDeviation += Math.pow(s.calculateMarkAverage() - mean, 2);
		}
		
		standardDeviation = Math.sqrt(standardDeviation / (students.size()-1));
		return standardDeviation;
	}

}
