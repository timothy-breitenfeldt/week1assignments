package exercise1;

import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		Scanner kin = new Scanner(System.in);
		int counter = 1;
		int programNum = 52;
		int userNum = 0;
		
		if (args.length == 2) {
			try {
			programNum =- Integer.parseInt(args[1]);
			} catch(NumberFormatException nfe) {
				System.out.println("Please provide an integer, or leave the argument blank.");
			}
		}
		
		do {
			userNum = readNumber(kin);
			
			if (userNum > programNum +10 || userNum < programNum - 10) {
				System.out.println("Not close enough, you have " + (5-counter) + " chances left.");
			}
			counter++;
		} while (counter <= 5 && (userNum > programNum +10 || userNum < programNum - 10));
		
		if (counter >= 5) {
			System.out.println("Sorry, you are out of chances.");
		} else {
			System.out.println("You were close enough. the number was " + programNum + " and your number was " + userNum + ".");
		}
		
		kin.close();
	}
	
	private static int readNumber(Scanner kin) {
		int num = 0;
		String input = "";
		
		do {
			System.out.print("guess a number: ");
			input = kin.nextLine().trim();
			
			try {
				num = Integer.parseInt(input);
			} catch(NumberFormatException nfe) {
				System.out.println("Please enter a number.");
				input = "";
			}
		} while (input.isEmpty());
		return num;
	}
	
}
