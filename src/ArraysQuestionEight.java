// Name: Hanz Nathan Po
// Created on: Dec 2, 2022
// Last edited: Dec 2, 2022
// Description: Takes in a positive integer and converts it into barcode form.

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ArraysQuestionEight {

	public static void main(String[] args) {
		// Declaration area
		int[] barcodeDigits;
		String input;
		String binaryBarcode;
		String[] barcodeChart = {"11000", "00011", "00101", "00110", "01001", "01010", "01100", "10001", "10010", "10100"};
		StringBuilder builder = new StringBuilder();
		JTextArea textArea = new JTextArea();
		
		// Ask user for input
		input = JOptionPane.showInputDialog(null, "Please enter a barcode number");

		// Array to store user input in integer form (adds a space for the check digit)
		barcodeDigits = new int[input.length() + 1];
		
		// Sets array to proper values, raises exception if the input is invalid
		try {
			for (int i = 0; i < input.length(); i++) {
				barcodeDigits[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please enter a valid barcode number (must be a positive integer)\n\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		// Sets check digit
		barcodeDigits[barcodeDigits.length - 1] = ceilToNearestTen(sumOfArray(barcodeDigits)) - sumOfArray(barcodeDigits);
		
		// Converts digits to barcode number equivalent and adds spaces in between numbers
		// A StringBuilder is used because it is more efficient than appending onto a normal String
		for (int i = 0; i < barcodeDigits.length; i++) {
			builder.append(barcodeChart[barcodeDigits[i]] + " ");
		}
		
		// Converts StringBuilder to string and clears it for reuse
		binaryBarcode = builder.toString();
		builder.setLength(0);
		
		// Converts 1's, 0's, and spaces into symbols
		for (int i = 0; i < binaryBarcode.length(); i++) {
			if (binaryBarcode.charAt(i) == '1') {
				builder.append("|");
			}
			else if (binaryBarcode.charAt(i) == '0') {
				builder.append(":");
			}
			else {
				builder.append(" ");
			}
		}
		
		// Removes last empty space
		builder.setLength(builder.length() - 1);
		
		// Sets settings for text area
		// Text area is used because it makes it easier for the user to copy the barcode
		textArea.setText(binaryBarcode + "\n\n" + builder.toString());
		textArea.setEditable(false);
		textArea.setLineWrap(false);  
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Courier New", Font.BOLD, 26));
		
		// Display output
		JOptionPane.showMessageDialog(null, textArea, "Barcode", JOptionPane.PLAIN_MESSAGE);
		
		// Exit program
		System.exit(0);
	}
	
	// Method to get the sum of an array
	public static int sumOfArray(int[] n) {
		int sum = 0;
		
		for (int i = 0; i < n.length; i++) {
			sum += n[i];
		}
		
		return sum;
	}
	
	// Method to round up to the nearest ten
	public static int ceilToNearestTen(int n) {
		double num = (double) n ;
		num = Math.ceil(num / 10) * 10;
		
		return (int) num;
	}

}
