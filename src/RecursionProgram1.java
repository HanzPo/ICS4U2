// Name: Hanz Nathan Po
// Date created: February 16, 2023
// Last modified: February 16, 2023
// Description: This application takes a given string of text and converts all occurrences of the letter E/e into the letter O/o. It is not case sensitive.

// Imports JOptionPane class.
import javax.swing.JOptionPane;

// Declares RecursionProgram1 class.
public class RecursionProgram1 {
	
	// Main method, runs on program start.
	public static void main(String[] args) {
		
		// Declaration of variables.
		String input; // Used to store the user's input
		String output; // Used to store the output from the eToO method.
		
		// Asks user for string input to be used on the eToO method.
		input = JOptionPane.showInputDialog(null, "Please enter a sentence to convert all E/e's into O/o's:\n", "E to O", JOptionPane.PLAIN_MESSAGE);
		// Stores the output of the eToO method.
		output = eToO(input);
		
		// Displays the output of the eToO method.
		JOptionPane.showMessageDialog(null, "Here is your sentence with all E/e's converted into O/o's:\n\n" + output);
		
		// Ensures the safe closing of the application.
		System.exit(0);
	} // End of main

	// Recursive method that looks for all instances of E/e in a given String and converts them into O/o. 
	public static String eToO (String inputString) {
		
		// Base case: returns input string if the string provided is empty.
		if (inputString.length() < 1) {
			return inputString;
		}
		
		// Checks to see if the first letter is an 'e'. If true, it will return an 'o' as well as the rest of the string, passed into the same method.
		if (inputString.charAt(0) == 'e') {
			return "o" + eToO(inputString.substring(1));
		}
		
		// Checks to see if the first letter is an 'E'. If true, it will return an 'O' as well as the rest of the string, passed into the same method.
		if (inputString.charAt(0) == 'E') {
			return "O" + eToO(inputString.substring(1));
		}
		
		// This case will be reached if the string is not empty, and there are no e's or E's. It will simply return the first character of the input string and the rest of the string passed into the same method.
		return inputString.charAt(0) + eToO(inputString.substring(1));
	} // End of eToO
} // End of RecursionProgram1 class
