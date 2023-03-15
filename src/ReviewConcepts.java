//Name:  M. Duarte, H. Po
//Created on:  Jan 10, 2010
//Last Edited:  Dec 19, 2022
//Description:  This is an implementation of the Tic Tac Toe game.

import javax.swing.JOptionPane;

public class ReviewConcepts {

	public static void main(String[] args) {

		//-------------------The Tic Tac Toe Program -------------
		String TicTacToe[][] = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}}; // Tic Tac Toe board
		String input; // String used to keep track of user input

		int Available[] = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // Choices available for the player
		int ComputerChoices[] = new int[9]; // Choices available for the computer
		int placeholder = 0; // Placeholder used to choose computer position

		int choice = 0;  //To get grid choice from user.
		int compChoice;  //The computer's choice.

		int gameState = 0; // Game keeps running when equal to zero
		int wins = 0; // Number of wins
		int ties = 0; // Number of ties
		int losses = 0; // Number of losses

		// Game repeats until gameState is set to something other than 0
		while(gameState == 0) {

			// Reset board
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					TicTacToe[i][j] = String.valueOf(3 * i + j + 1);
				}
			}

			// Reset available choices
			for (int i = 0; i < 9; i++) {
				Available[i] = i + 1;
			}

			// Show welcome message
			JOptionPane.showMessageDialog(null, "Welcome to Tic Tac Toe! \n"
					+ "You will play with 'X' and "
					+ "the computer will play with 'O'. \n"
					+ "You shall play first. \n\n"
					+ "The boxes in the grid are numbered as followed: \n \n"
					+ "     1     |     2     |     3      \n"
					+ "------------------------------ \n"
					+ "     4     |     5     |     6      \n"
					+ "------------------------------ \n"
					+ "     7     |     8     |     9      \n\n\n"
					+ "Play by entering the number of the box where you wish to place your 'X'. \n"
					+ "Good Luck!");

			// Loop through all five turn pairs
			for (int i = 0; i < 5; i++)
			{
				placeholder = 0;  //Set and Reset the placeholder on Computer Choices array.

				// Keep asking user for input until a valid one is provided
				do {

					input = JOptionPane.showInputDialog(null, printBoard(TicTacToe) + "\n\n Enter your box choice to put 'X': ", "TIC TAC TOE", JOptionPane.QUESTION_MESSAGE);

					// Added way of exiting program if you press cancel or the x button 
					if (input == null) {
						if (JOptionPane.showConfirmDialog(null, "Are you sure you would like to exit the program?", "Exit?", JOptionPane.YES_NO_OPTION) == 0) {
							System.exit(0);
						}
						continue;
					}

					try {
						choice = Integer.parseInt(input);
					}
					catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Please enter a valid integer\n" + e, "Not a number", JOptionPane.ERROR_MESSAGE);
						continue;
					}

					if (choice < 1 || choice > 9) {
						JOptionPane.showMessageDialog(null, "Please enter a number between 0 and 9", "Invalid number", JOptionPane.ERROR_MESSAGE);
						continue;
					}
					else if (!inArray(Available, choice)) {
						JOptionPane.showMessageDialog(null, "That number is already taken", "Invalid number", JOptionPane.ERROR_MESSAGE);
						continue;
					}

				} while (!inArray(Available, choice) || choice < 1 || choice > 9);

				// Remove chosen position from available list
				Available[choice - 1] = 0;

				// Plot user input onto board
				if (choice == 1)
				{
					TicTacToe[0][0] = "X";
				}
				if (choice == 2)
				{
					TicTacToe[0][1] = "X";
				}
				if (choice == 3)
				{
					TicTacToe[0][2] = "X";		
				}
				if (choice == 4)
				{
					TicTacToe[1][0] = "X";		 
				}
				if (choice == 5)
				{
					TicTacToe[1][1] = "X";	
				}
				if (choice == 6)
				{
					TicTacToe[1][2] = "X";	 
				}
				if (choice == 7)
				{
					TicTacToe[2][0] = "X";	
				}
				if (choice == 8)
				{
					TicTacToe[2][1] = "X";
				}
				if (choice == 9)
				{
					TicTacToe[2][2] = "X";
				}

				// Check if user wins
				// Check horizontal wins
				if ((TicTacToe[0][0] == "X" && TicTacToe[0][1] == "X" && TicTacToe[0][2] == "X")
						|| (TicTacToe[1][0] == "X" && TicTacToe[1][1] == "X" && TicTacToe[1][2] == "X")
						|| (TicTacToe[2][0] == "X" && TicTacToe[2][1] == "X" && TicTacToe[2][2] == "X"))
				{
					JOptionPane.showMessageDialog(null, "You won!\n\n" + printBoard(TicTacToe));
					wins++;
					break;
				}
				// Check vertical wins
				if ((TicTacToe[0][0] == "X" && TicTacToe[1][0] == "X" && TicTacToe[2][0] == "X")
						|| (TicTacToe[0][1] == "X" && TicTacToe[1][1] == "X" && TicTacToe[2][1] == "X")
						|| (TicTacToe[0][2] == "X" && TicTacToe[1][2] == "X" && TicTacToe[2][2] == "X"))
				{
					JOptionPane.showMessageDialog(null, "You won!\n\n" + printBoard(TicTacToe));
					wins++;
					break;
				}
				// Check diagonal wins
				if ((TicTacToe[0][0] == "X" && TicTacToe[1][1] == "X" && TicTacToe[2][2] == "X")
						|| (TicTacToe[2][0] == "X" && TicTacToe[1][1] == "X" && TicTacToe[0][2] == "X"))
				{
					JOptionPane.showMessageDialog(null, "You won!\n\n" + printBoard(TicTacToe));
					wins++;
					break;
				}

				//See if last move made. If nobody has won yet, it's a tie.

				if (i == 4)
				{
					JOptionPane.showMessageDialog(null, "You tied!\n\n" + printBoard(TicTacToe));
					ties++;
					break;
				}

				//Prepare choices for the computer from what is available.

				for (int j = 0; j < 9; j++)
				{
					if (Available[j] != 0)
					{
						ComputerChoices[placeholder] = Available[j];
						placeholder++;
					}
				}

				//Computer makes a random choice of what's available in ComputerChoices array.  Then that choice is no longer Available.

				compChoice = ((int)(Math.random()*placeholder));

				Available[ComputerChoices[compChoice] - 1] = 0;

				if (ComputerChoices[compChoice] == 1)
				{
					TicTacToe[0][0] = "O";
				}
				if (ComputerChoices[compChoice] == 2)
				{
					TicTacToe[0][1] = "O";
				}
				if (ComputerChoices[compChoice] == 3)
				{
					TicTacToe[0][2] = "O";		
				}
				if (ComputerChoices[compChoice] == 4)
				{
					TicTacToe[1][0] = "O";		 
				}
				if (ComputerChoices[compChoice] == 5)
				{
					TicTacToe[1][1] = "O";	
				}
				if (ComputerChoices[compChoice] == 6)
				{
					TicTacToe[1][2] = "O";	 
				}
				if (ComputerChoices[compChoice] == 7)
				{
					TicTacToe[2][0] = "O";	
				}
				if (ComputerChoices[compChoice] == 8)
				{
					TicTacToe[2][1] = "O";
				}
				if (ComputerChoices[compChoice] == 9)
				{
					TicTacToe[2][2] = "O";
				}

				// Check if computer wins
				// Check horizontal wins
				if ((TicTacToe[0][0] == "O" && TicTacToe[0][1] == "O" && TicTacToe[0][2] == "O")
						|| (TicTacToe[1][0] == "O" && TicTacToe[1][1] == "O" && TicTacToe[1][2] == "O")
						|| (TicTacToe[2][0] == "O" && TicTacToe[2][1] == "O" && TicTacToe[2][2] == "O"))
				{
					JOptionPane.showMessageDialog(null, "You lost!\n\n" + printBoard(TicTacToe));
					losses++;
					break;
				}
				// Check vertical wins
				if ((TicTacToe[0][0] == "O" && TicTacToe[1][0] == "O" && TicTacToe[2][0] == "O")
						|| (TicTacToe[0][1] == "O" && TicTacToe[1][1] == "O" && TicTacToe[2][1] == "O")
						|| (TicTacToe[0][2] == "O" && TicTacToe[1][2] == "O" && TicTacToe[2][2] == "O"))
				{
					JOptionPane.showMessageDialog(null, "You lost!\n\n" + printBoard(TicTacToe));
					losses++;
					break;
				}
				// Check diagonal wins
				if ((TicTacToe[0][0] == "O" && TicTacToe[1][1] == "O" && TicTacToe[2][2] == "O")
						|| (TicTacToe[2][0] == "O" && TicTacToe[1][1] == "O" && TicTacToe[0][2] == "O"))
				{
					JOptionPane.showMessageDialog(null, "You lost!\n\n" + printBoard(TicTacToe));
					losses++;
					break;
				}


			} // End of game for loop


			gameState = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Game", JOptionPane.YES_NO_OPTION);

		} // End of while loop that repeats the game until user quits

		// Prints out user stats
		JOptionPane.showMessageDialog(null, "Hope you had fun! Here are your stats for this game session:\nWins: " + wins + "\nTies: " + ties + "\nLosses: " + losses, "Game end stats", JOptionPane.PLAIN_MESSAGE);

		// Exits game
		System.exit(0);
	}

	// Prints board
	public static String printBoard(String[][] board) {

		String boardString = "     " + board[0][0] + "     |     " + board[0][1] + "     |     " + board[0][2] + "      \n"
				+ "------------------------------ \n"
				+ "     " + board[1][0] + "     |     " + board[1][1] + "     |     " + board[1][2] + "      \n"
				+ "------------------------------ \n"
				+ "     " + board[2][0] + "     |     " + board[2][1] + "     |     " + board[2][2] + "      \n";

		return boardString;
	}

	// Checks if value is in array
	public static boolean inArray(int[] array, int value) {
		for (int i : array) {
			if (i == value) {
				return true;
			}
		}
		return false;
	}
}  
