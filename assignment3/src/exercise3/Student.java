package exercise3;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private String name;
	private List<Integer> marks;
	private int totalMarks;
	
	public Student(String name, int mark) {
		this.name = name;
		this.marks = new ArrayList<Integer>();
		this.totalMarks = mark;
		this.marks.add(mark);
	}

	public String getName() {
		return name;
	}

	public List<Integer> getMarks() {
		return marks;
	}

	public int getTotalMarks() {
		return totalMarks;
	}
	
	public void addMark(int mark) {
		this.totalMarks += mark;
		this.marks.add(mark);
	}
	
	public double calculateMarkAverage() {
		return (this.totalMarks / this.marks.size());
	}
	
}
