// Name: Hanz Nathan Po
// Date created: February 16, 2023
// Last modified: February 16, 2023
// Description: A program that looks for instances of "n" and replaces them with "nn", as well as finding instances of "nn" and converting them to "n". Also known as the “Nanny nnany” program

// Imports JOptionPane class.
import javax.swing.JOptionPane;

// Declares RecursionProgram3 class.
public class RecursionProgram3 {
	
	// Main method, runs on program start.
	public static void main(String[] args) {
		
		// Declaration of variables.
		String input; // Used to store the user's input
		String output; // Used to store the output from the nSwitchWithNn method.
		
		// Asks user for string input to be used on the nSwitchWithNn method.
		input = JOptionPane.showInputDialog(null, "This program converts all double n's into single n's, and converts all single n's into double n's. \nIt also makes all letters lowercase. E.g. \"Nanny\" becomes \"nnany\". Please enter a string below:\n", "The Nanny nnany program", JOptionPane.PLAIN_MESSAGE);
		
		// Converts all characters in string to their lowercase counterparts.
		input = input.toLowerCase();
		
		// Stores the output of the nSwitchWithNn method.
		output = nSwitchWithNn(input);
		
		// Displays the output of the nSwitchWithNn method.
		JOptionPane.showMessageDialog(null, "Here is the converted text:\n\n" + output);
		
		// Ensures the safe closing of the application.
		System.exit(0);
	} // End of main

	// Recursive method that looks for instances of "n" and replaces them with "nn", as well as finding instances of "nn" and replacing them with "n".
	public static String nSwitchWithNn (String inputString) {
		
		// Base case: returns input string if the input string is empty.
		if (inputString.length() < 1) {
			return inputString;
		}
		
		// Checks if the first character is "n".
		if (inputString.charAt(0) == 'n') {
			
			// Makes sure that the method is checking a character that actually exists.
			if (inputString.length() > 1) {
				
				// If the first character is n, check if the second character is also n, therefore looking for "nn".
				if (inputString.charAt(1) == 'n')
				{
					
					// If "nn" is the start of the string, replace it with "n" and pass the rest of the string into the same method.
					return "n" + nSwitchWithNn(inputString.substring(2));
					
				}
				
			}
			
			// If the second letter is not "n", then the beginning of the string has just one "n". Replace it with "nn" and pass the rest of the string into the same method.
			return "nn" + nSwitchWithNn(inputString.substring(1));
		}
		
		// Returns the last letter of the input string and passes the rest of the string into the method.
		return inputString.charAt(0) + nSwitchWithNn(inputString.substring(1));
		
	} // End of nSwitchWithNn
} // End of RecursionProgram3 class

