// Name: Hanz Nathan Po
// Created on: Dec 1, 2022
// Last edited: Dec 2, 2022
// Description: Generates all prime numbers up to a specified positive integer greater than 2.

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class ArraysQuestionSeven {

	public static void main(String[] args) {
		// Create variables and instantiate objects
		int nums = 0;
		int[] primes;
		String primesString;
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		// Ask user for input and exit if invalid
		try {
			nums = Integer.parseInt(JOptionPane.showInputDialog("Please enter a positive integer"));
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid input!\n\n" + e, "Invalid input", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		// Call method for the sieve of erathosthenes, which returns an array
		primes = sieveOfEratosthenes(nums);
		
		// Convert array to string and remove brackets
		primesString = Arrays.toString(primes);
		primesString = primesString.substring(1, primesString.length() - 1);
		
		// Make output scrollable and display to user
		textArea.setText(primesString);
		textArea.setEditable(false);
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true);
		scrollPane.setPreferredSize(new Dimension(800, 400));
		JOptionPane.showMessageDialog(null, scrollPane, "Prime Numbers up to " + nums, JOptionPane.PLAIN_MESSAGE);
		
		// Exit program
		System.exit(0);
	}

	// Returns an integer array of prime numbers up to a given n
	public static int[] sieveOfEratosthenes(int n) {
		
		// Return empty array if n is less than n (there are no primes less than n)
		if (n < 2) {
			return new int[0];
		}

		// Create array of booleans set true by default
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		
		// Create ArrayList to store prime numbers
		ArrayList<Integer> primeNums = new ArrayList<Integer>();
		
		// Eliminate multiples of every value set to true. Remaining values are prime.
		// Only iterate up to the square root of n because all composite numbers have a prime factor that is equal to or less than its square root
		for (int i = 2; i < Math.ceil(Math.sqrt(n)); i++) {
			// If the next number in the array is prime, eliminate all of its multiples, because they must be composite
			if (prime[i]) {
				for (int j = (int) Math.pow(i, 2); j < n + 1; j += i) {
					prime[j] = false;
				}
			}
		}
		
		// Generate ArrayList of primes from array of bools (i starts at two to avoid 0 and 1, which are not primes)
		for (int i = 2; i < n + 1; i++) {
			if (prime[i]) {
				primeNums.add(i);
			}
		}
		
		// Convert ArrayList to array of ints
		return primeNums.stream().mapToInt(i -> i).toArray();
	}
}
