// Name: Hanz Nathan Po
// Date created: February 16, 2023
// Last modified: February 16, 2023
// Description: A program that takes in a name and reverses the order of the characters.

// Imports JOptionPane class.
import javax.swing.JOptionPane;

// Declares RecursionProgram2 class.
public class RecursionProgram2 {
	
	// Main method, runs on program start.
	public static void main(String[] args) {
		
		// Declaration of variables.
		String input; // Used to store the user's input
		String output; // Used to store the output from the reverseString method.
		
		// Asks user for string input to be used on the reverseString method.
		input = JOptionPane.showInputDialog(null, "Please enter a name to reverse the letters of:\n", "Name Reverser", JOptionPane.PLAIN_MESSAGE);
		// Stores the output of the reverseString method.
		output = reverseString(input);
		
		// Displays the output of the reverseString method.
		JOptionPane.showMessageDialog(null, "Here is your name with all of the letters reversed:\n\n" + output);
		
		// Ensures the safe closing of the application.
		System.exit(0);
	} // End of main

	// Recursive method that looks for all instances of E/e in a given String and converts them into O/o. 
	public static String reverseString (String inputString) {
		
		// Base case: returns input string if the input string is empty.
		if (inputString.length() < 1) {
			return inputString;
		}
		
		// Returns the last letter of the input string and passes the rest of the string into the method.
		return inputString.charAt(inputString.length() - 1) + reverseString(inputString.substring(0, inputString.length() - 1));
		
	} // End of reverseString
} // End of RecursionProgram2 class

