/* Created by: Hanz Nathan Po
 * Date Created: Sept 27, 2022
 * Last Updated: Sept 27, 2022
 * Description: A program which gives the user a verse from the song "Twelve Days of Christmas" depending on their input.
 */

import javax.swing.JOptionPane;

public class TwelveDaysOld {

	public static void main(String[] args) {
		
		int choice;
		
		choice = getChoice("Which day of Christmas would you like to get?");
		
		switch (choice) {
			case 1:
				showOutput("A partridge in a pear tree");
				break;
			case 2:
				showOutput("Two turtle doves");
				break;
			case 3:
				showOutput("Three French hens");
				break;
			case 4:
				showOutput("Four calling birds");
				break;
			case 5:
				showOutput("Five gold rings");
				break;
			case 6:
				showOutput("Six geese a-laying");
				break;
			case 7:
				showOutput("Seven swans a-swimming");
				break;
			case 8:
				showOutput("Eight maids a-milking");
				break;
			case 9:
				showOutput("Nine ladies dancing");
				break;
			case 10:
				showOutput("Ten lords a-leaping");
				break;
			case 11:
				showOutput("Eleven pipers piping");
				break;
			case 12:
				showOutput("Twelve drummers drumming");
				break;
			default:
				showOutput("Invalid input");
				break;
		}
		
		System.exit(0);
		
	} // end main

	public static int getChoice(String prompt) {
		int choice;
		
		choice = Integer.parseInt(JOptionPane.showInputDialog(null, prompt));
		
		return choice;
	}
	
	public static void showOutput(String output) {
		JOptionPane.showMessageDialog(null, output, "Twelve Days of Christmas", JOptionPane.PLAIN_MESSAGE);
	}
	
} // end class
