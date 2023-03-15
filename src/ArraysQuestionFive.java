// Name: Hanz Nathan Po
// Created on: Nov 28, 2022
// Last edited: Nov 29, 2022
// Description: Prints out a string of decreasing length.

import javax.swing.JOptionPane;

public class ArraysQuestionFive {

	public static void main(String[] args) {
		
		String myString;
		StringBuilder builder = new StringBuilder();
		
		myString = JOptionPane.showInputDialog(null, "Please enter a string");
		
		for (int i = 0; i < myString.length(); i++) {
			builder.append(myString.substring(i, myString.length()) + "\n");
		}
		
		JOptionPane.showMessageDialog(null, builder);
		
		System.exit(0);
	}

}
