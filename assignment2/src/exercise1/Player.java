package exercise1;
import java.util.*;

public class Player
{
	private String name;
	private int score;
	
	public player()
	{
		name = askName();
		score = 0;
	}
	/*
	 * GETTERS / SETTERS
	 */
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	/*
	 * HELPER METHODS
	 */
	
	//ASK THE NAME
	private String askName()
	{
		Scanner scan = new Scanner(System.in);
		//prompt question will be in main
		String player = scan.nextLine();
		//bool to loop until valid name is input.
		boolean check = checkValidName(player);
		while(!check)
		{
			player = scan.nextLine();
			check = checkValidName(player);
		}
		return player;
	}
	//CHECK IF NAME IS VALID (ALLOWS APOSTROPHE AND HYPHENS)
	private boolean checkValidName(String input)
	{
		boolean valid = (!input.equalsIgnoreCase("")) && (input != null) && (input.matches("^[a-zA-Z'-]*$"));
		if(!valid)
		{
			System.out.println("Enter proper name!");
		}
		return valid;
	}
	
	private boolean equals(player player2)
	{
		return (this.name.equalsIgnoreCase(player2.getName()) && this.score == player2.getScore());
	}
}
