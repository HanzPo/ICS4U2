// Name: Hanz Nathan Po
// Created on: Nov 28, 2022
// Last edited: Dec 29, 2022
// Description: Prints out 25 numbers in a row

import javax.swing.JOptionPane;

public class ArraysQuestionFour {
	
	public static void main(String[] args) {
		
		int[] myArray = new int[25];
		StringBuilder builder = new StringBuilder();
		
		
		int numsInRow = 0;
		
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = i;
			
			builder.append("arr[" + i + "] = " + myArray[i] + ", ");
			numsInRow++;
			
			if (numsInRow >= 5) {
				builder.append("\n");
				numsInRow = 0;
			}
		}
		
		builder.setLength(builder.length() - 3);
		
		JOptionPane.showMessageDialog(null, builder);
		
		System.exit(0);
	}
	
}
