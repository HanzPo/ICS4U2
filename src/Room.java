// Created by: Hanz Po
// Date created: September 9th, 2022
// Last modified: September 9th, 2022
// Description: A program which takes the dimensions of a room and calculates the area.

// Import JOptionPane
import javax.swing.JOptionPane;

public class Room {

	public static void main(String[] args) {
		// Initialize variables
		int length = 0;
		int width = 0;

		// Input
		length = Integer.parseInt(JOptionPane.showInputDialog("Please enter a length"));
		width = Integer.parseInt(JOptionPane.showInputDialog("Please enter a width"));
		
		// Output
		System.out.println("The floor space is " + (length * width) + " square feet");
		JOptionPane.showMessageDialog(null, "The floor space is " + (length * width) + " square feet");

		System.exit(0);
	}

}
