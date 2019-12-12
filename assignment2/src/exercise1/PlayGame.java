package exercise1;
import java.util.*;

class PlayGame {
	
	public static void main(String args[])
	{
		//if start from the beginning - asking players do while loop from the start, else do it within the playGame function
		boolean continueGame = true;
		
		while(continueGame)
		{
		//create a list of players
			player[] players = createNewPlayers();
		//allow player to choose initial chip for the game
			int initialChips = inputChips();
		//TODO: play the game
			playGame(players, initialChips);
			continueGame = playAgain();
		}
	}
	
	/*
	 * METHODS TO SET THE GAME 
	 */
	//method to create the players
	private static player[] createNewPlayers()
	{
		//create a list of 2 players
		player[] players = new player[2];
		System.out.println("Enter first player name:");
		player player1 = new player(); //constructor handles the name validity
		System.out.println("Enter second player name:");
		player player2 = new player();
		//loop to check if player name is the same
		while(player1.equals(player2)) // equals method within player object class
		{
			System.out.println("Names cannot be a duplicate, try a different name.");
			player2 = new player(); //
		}
		players[0] = player1;
		players[1] = player2;
		return players;
	}
	
	//method to create the initial chips
	private static int inputChips()
	{
		int input = 0;
		//checks if input for the starting chips is valid
		System.out.println("How many chips does the initial pile contain?");
		while(input <= 2 || input % 2 == 0)
		{
			Scanner scan = new Scanner(System.in);
			try
			{
				input = scan.nextInt();
				if(input <= 2)
					System.out.println("Illegal Input: Starting chips must be atleast 3 or more.");
				if(input % 2 == 0)
					System.out.println("Illegal Input: Starting chips must be odd.");
			}
			catch(InputMismatchException e)
			{
				System.out.println("Must input integers");
				continue;
			}
		}
		return input;
	}
	
	/*
	 * METHODS TO PLAY THE GAME:
	 */
	private static void playGame(player[] players, int initialChips)
	{
		int turn = 0; //The turns will ONLY be 0 and 1, this will allow us to access specific player within the list.
		int remainingChips = initialChips; //counter for the current chip.
		while(remainingChips != 0)
		{
			display(players);
			int chipsTaken = takeChips(players[turn], remainingChips);
			players[turn].setScore(chipsTaken + players[turn].getScore());
			remainingChips -= chipsTaken;
			if(turn == 0)
				turn = 1;
			else
				turn = 0;
		}
		//determine winner
		display(players);
		player winner = players[0];
		if(winner.getScore() % 2 != 0)
			winner = players[1];
		System.out.println("The winner is " + winner.getName() + "!");
		
	}
	
	 private static void display(player[] players) 
	 {
			System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * ");
			System.out.println(players[0].getName() + " has " + players[0].getScore() + " chips.");
			System.out.println(players[1].getName() + " has " + players[1].getScore() + " chips.");
	}
	
	private static int takeChips(player player, int remainingChips)
	{
		int taken;
		Scanner sc = new Scanner(System.in);  
    
		System.out.println("It is your turn, " + player.getName() + ".");
		System.out.println("There are " + remainingChips + " chips remaining.");
    
		if(remainingChips / 2 != 0)
			System.out.println("You may take any number of chips from 1 to " + remainingChips / 2 + ".");
		else
			System.out.println("You may only take 1 chips.");
		do {
			System.out.println("How many will you take, " + player.getName() + "?");
			while (!sc.hasNextInt()) {
		        System.out.println("Illegal move: You must enter an integer.");
		        sc.next();
		    }
			taken = sc.nextInt();
		    if (taken < 1) {
		    	System.out.println("Illegal move: you must take at least one chip.");
		    }
		    else if (taken == 1) {
		    	return 1;
		    }
		    else if (taken > remainingChips / 2) {
		    	System.out.println("Illegal move: you may not take more than " + remainingChips / 2 + " chips.");
		    }
		} while (taken < 1 || taken > remainingChips / 2);
		return taken;
	}
	/*
	 * METHOD TO PLAY AGAIN
	 */
	public static boolean playAgain() {
		Scanner kin = new Scanner(System.in);
		String answer = "";
		do {
			System.out.print("Would you like to play again? ");
			answer = kin.nextLine();
		}
		while ( !answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));
		return answer.equalsIgnoreCase("y");
	}
}
