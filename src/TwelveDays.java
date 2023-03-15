/* Created by: Hanz Nathan Po
 * Date Created: Sept 27, 2022
 * Last Updated: Sept 27, 2022
 * Description: A program which gives the user a verse from the song "Twelve Days of Christmas" depending on their input.
 */

import javax.swing.JOptionPane;

public class TwelveDays {

	public static void main(String[] args) {
		
		
		int choice;
		
		choice = getChoice("Which verse from the Twelve Days of Christmas would you like to get?");
		
		switch (choice) {
			case 1:
				showOutput(daysOfChristmas(1));
				break;
			case 2:
				showOutput(daysOfChristmas(2));
				break;
			case 3:
				showOutput(daysOfChristmas(3));
				break;
			case 4:
				showOutput(daysOfChristmas(4));
				break;
			case 5:
				showOutput(daysOfChristmas(5));
				break;
			case 6:
				showOutput(daysOfChristmas(6));
				break;
			case 7:
				showOutput(daysOfChristmas(7));
				break;
			case 8:
				showOutput(daysOfChristmas(8));
				break;
			case 9:
				showOutput(daysOfChristmas(9));
				break;
			case 10:
				showOutput(daysOfChristmas(10));
				break;
			case 11:
				showOutput(daysOfChristmas(11));
				break;
			case 12:
				showOutput(daysOfChristmas(12));
				break;
			default:
				JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
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
	
	public static String daysOfChristmas(int day) {
		String[] verses = new String[] {	"A partridge in a pear tree", 
											"And a partridge in a pear tree", 
											"Two turtle doves",
											"Three French hens",
											"Four calling birds",
											"Five gold rings",
											"Six geese a-laying",
											"Seven swans a-swimming",
											"Eight maids a-milking",
											"Nine ladies dancing",
											"Ten lords a-leaping",
											"Eleven pipers piping",
											"Twelve drummers drumming"      };

		String[] numbers = new String[] {"", "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"};

		StringBuilder builder = new StringBuilder();
		
		builder.append("On the ");
		builder.append(numbers[day]);
		builder.append(" of Christmas my true love sent to me");
		
		for (int i = day; i > 0; i--) {
			
			builder.append(i == day ? "\n" : ",\n");
			builder.append(day == 1 ? verses[0] : verses[i]);
			
			if (i == 1) {
				builder.append(".");
			}
		}
		
		return builder.toString();
	}
	
} // end class
