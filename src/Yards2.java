// Created by: Hanz Po
// Date created: September 9th, 2022
// Last modified: September 9th, 2022
// Description: A program that takes the dimensions of a room and the price of carpet in order to calculate the price of carpeting a floor. The program can also repeat if the user would like it to.

// Import JOptionPane
import javax.swing.JOptionPane;

public class Yards2 {

	public static void main(String[] args) {

		// Initialize variables
		double length = 0.0;
		double width = 0.0;
		double price = 0.0;
		boolean repeat = true;

		while (repeat) {
			// Input
			length = Double.parseDouble(JOptionPane.showInputDialog("Please enter the carpet's length"));
			width = Double.parseDouble(JOptionPane.showInputDialog("Please enter the carpet's width"));
			price = Double.parseDouble(JOptionPane.showInputDialog("Please enter the price of carpet per square yard"));

			// Output
			JOptionPane.showMessageDialog(null, "It will cost $" + 
					roundDigits((((length * width) / 9.0) * price), 2) + 
					" to carpet " + roundDigits((length * width) / 9.0, 2) + " yards of floor.");

			// Ask user if the program should be repeated
			switch (JOptionPane.showConfirmDialog(null, "Would you like to run the program again?", "Message", JOptionPane.YES_NO_OPTION)) {
			case 0:
				break;
			case 1:
				repeat = false;
				break;
			}	
		}

		System.exit(0);
	}

	// Rounds number to a specified number of decimal places
	public static double roundDigits(double number, int decimalPlaces) {
		return Math.round(number * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);
	}

}

