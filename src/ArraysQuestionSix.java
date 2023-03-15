// Name: Hanz Nathan Po
// Created on: Nov 30, 2022
// Last edited: Dec 1, 2022
// Description: Takes in a 9 digit social insurance number and checks its validity.

import javax.swing.JOptionPane;

public class ArraysQuestionSix {

	public static void main(String[] args) {
		// Declare variables and arrays
		String sin = "";
		int total = 0;
		int[] sinInt = new int[9];
		int[] firstSet = new int[4];
		int[] secondSet = new int[4];
		
		// Ask user to enter input
		sin = JOptionPane.showInputDialog(null, "Please enter your SIN in the format XXX-XXX-XXX:", "SIN Checker", JOptionPane.PLAIN_MESSAGE).replace("-", "");
		
		// Checks to see if input is valid and converts string into array of integers
		try {
			for (int i = 0; i < 9; i++) {
				sinInt[i] = Integer.parseInt(String.valueOf(sin.charAt(i)));
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid input!\n\n" + e);
			System.exit(1);
		}
		
		// Combine every other digit into an array
		for (int i = 0; i < 4; i ++) {
			firstSet[i] = sinInt[i * 2];
		}
		
		// Combine second set of every other digit and multiply by two
		for (int i = 0; i < 4; i++) {
			secondSet[i] = sinInt[(i * 2) + 1] * 2;
			
			// Add digits if number has two digits
			if (secondSet[i] >= 10) {
				String stringNum = String.valueOf(secondSet[i]);
				secondSet[i] = Integer.parseInt(String.valueOf(stringNum.charAt(0))) + Integer.parseInt(String.valueOf(stringNum.charAt(1)));
			}
		}
		
		// Add up totals
		total = sumOfArray(firstSet) + sumOfArray(secondSet);
		
		// Check validity of SIN and tell user
		if ((10 - (total % 10) % 10) == sinInt[sinInt.length - 1]) {
			JOptionPane.showMessageDialog(null, "<html>This SIN number is<br><font color=#26bd2d size=200>VALID</font>");
		}
		else {
			JOptionPane.showMessageDialog(null, "<html>This SIN number is<br><font color=#ff0505 size=200>NOT VALID</font>");
		}
		
		System.exit(0);
	}
	
	// Gets sum of an array
	public static int sumOfArray(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		return sum;
	}
}
