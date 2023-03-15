// Name: Hanz Nathan Po
// Date created: February 16, 2023
// Last modified: February 16, 2023
// Description: This application is a Java implementation of the merge sort algorithm using recursion.

// Imports JOptionPane class.
import javax.swing.JOptionPane;

// Declaration of MergeSort class.
public class MergeSort {

	// Main method, runs at startup
	public static void main(String[] args) {

		// Variable and array declarations
		boolean alphabetical; // This variable decides whether the final list is sorted alphabetically or reverse alphabetically.
		int namesCount; // This variable specifies the number of names to be sorted.
		int sortChoice; // This variable specifies which sort choice the user requested.
		String outputString; // This variable is used to temporarily store the StringBuilder's contents to prepare it for the user to see.
		
		String[] names; // This list contains the names to be sorted.
		String[] sortedNames; // This list contains the names after being sorted.
		Object[] sortOptions; // This list contains the options presented to the user on how to sort the final list.

		// Used when outputting text to the user, more memory efficient than simply appending strings together.
		StringBuilder builder;

		// Initializes StringBuilder
		builder = new StringBuilder();
		
		
		sortOptions = new Object[]{"Alphabetically", "Reverse Alphabetically"}; // This assigns the two options presented to the user on how to sort the final list.

		// Asks the user how many names they would like to enter
		namesCount = Integer.parseInt(JOptionPane.showInputDialog(null, "This is a program that takes a number of names\nand gives them back to you, sorted. Please tell\nme how many names you would like to enter below:\n\n", "Names Merge Sort", JOptionPane.PLAIN_MESSAGE));

		// Creates an empty list of Strings with the length provided by the user.
		names = new String[namesCount];

		// For loop iterates through each item in the names array and asks the user to assign a value to it.
		for (int i = 0; i < names.length; i++) {

			// Declaration of variables that are temporarily used in the for loop.
			String currentName;
			int currentNumber;

			// Makes the number presented to the user start at 1, not 0, because humans (usually) don't start at 0.
			currentNumber = i + 1;

			// Shows user which name they're currently entering and asks them to enter it.
			currentName = JOptionPane.showInputDialog(null, "Please enter name " + currentNumber + " of " + names.length, "Entering name " + currentNumber + " of " + names.length, JOptionPane.PLAIN_MESSAGE);

			// Does the actual assignment of the user's string into the names array.
			names[i] = currentName;
		}

		// Presents the option of sorting alphabetically or reverse alphabetically to the user and assigns it to sortChoice.
		sortChoice = JOptionPane.showOptionDialog(null, "How would you like to sort the names?", "Sort Option", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, sortOptions, sortOptions[1]);

		// Sets alphabetical to true if alphabetical was chosen by the user, otherwise it is set to false
		alphabetical = (sortChoice == 0) ? true : false;

		// Runs unsorted names through mergeSort method and assigns the sorted names to the variable, sortedNames. The boolean which determines the order of the sorting is also passed into the mergeSort method.
		sortedNames = mergeSort(names, alphabetical);
		
		// For loop iterates through each item in sortedNames and appends it to the StringBuilder in order to prepare it for the user to see.
		for (int i = 0; i < namesCount; i++) {
			// Integer that simply adds one to the current index, because humans tend to start at 1, not 0.
			int currentNum = i + 1;
			builder.append(currentNum + ") " + sortedNames[i] + "\n");
		}

		// Converts contents of StringBuilder into a String.
		outputString = builder.toString();
		
		// Displays output to user
		JOptionPane.showMessageDialog(null, "Here is your list of names, sorted:\n\n" + outputString, "Sorted List", JOptionPane.PLAIN_MESSAGE);
		
		// Ensures the safe closing of the application.
		System.exit(0);
	}

	// Merge method. Merges two arrays of Strings together. A boolean is passed in to determine whether to merge alphabetically or reverse alphabetically.
	public static String[] merge(String[] unmergedList1, String[] unmergedList2, boolean sortAlpha) {

		int index1 = 0; // Tracks the position of list 1.
		int index2 = 0; // Tracks the position of list 2.

		// Creates a new list with the same length as both unsorted lists added together.
		String[] mergedList = new String[unmergedList1.length + unmergedList2.length];

		// Iterates through each item in merged List
		for (int i = 0; i < mergedList.length; i++) {
			// Checks if it should sort alphabetically or reverse alphabetically
			if (sortAlpha) {
				// Checks to see if all items in second unmerged list have already been added to the merged list OR the next item in the first unmerged list exists and should come before the next item in the second unmerged list.
				if (index2 >= unmergedList2.length || (index1 < unmergedList1.length && unmergedList1[index1].compareToIgnoreCase(unmergedList2[index2]) < 0)) {
					// If true, appends the next item in the first unmerged list to the merged list.
					mergedList[i] = unmergedList1[index1];
					// Increases the index to ensure items are not repeated
					index1++;
				}
				// If all the above conditions are not met, then the next item must be from the second unmerged list. 
				else {
					mergedList[i] = unmergedList2[index2];
					// Increases the index to ensure items are not repeated
					index2++;
				}
			}
			// Almost identical to the code in the if statement above, but sorts reverse alphabetically instead of alphabetically.
			else {
				if (index2 >= unmergedList2.length || (index1 < unmergedList1.length && unmergedList1[index1].compareToIgnoreCase(unmergedList2[index2]) >= 0)) {
					mergedList[i] = unmergedList1[index1];
					index1++;
				}
				else {
					mergedList[i] = unmergedList2[index2];
					index2++;
				}
			}
		}

		// Returns merged list.
		return mergedList;

	} // End of merge method.

	// Using the merge method, sorts an array of strings.
	public static String[] mergeSort (String[] unsortedList, boolean sortAlpha) {
		
		// Declaration of arrays
		String[] sortedList = new String[unsortedList.length]; // This array will be used to store the final sorted list. It must therefore have the same length as the unsorted list.
		String[] halfList1; // This array will be used to store the first half list.
		String[] halfList2; // This array will be used to store the second half list.

		int listSize1 = unsortedList.length/2; // Ideally, both half lists should be roughly the same size. Therefore, this variable stores the size of the first half list and takes roughly half the length of the full unsorted list.
		int listSize2 = unsortedList.length - listSize1; // This variable contains the length of the second half list, and therefore has the size of the full unsorted list minus the first half list.

		// Base case: Checks to see if the unsorted list is empty or has only one item (and therefore does not need to be sorted). If so, simply return the unsorted list.
		if (unsortedList.length < 2) {
			return unsortedList;
		}

		// Set both half lists to their proper sizes.
		halfList1 = new String[listSize1];
		halfList2 = new String[listSize2];

		// Assign the elements of the first half list.
		for (int i = 0; i < listSize1; i++) {
			halfList1[i] = unsortedList[i];
		}

		// Assign the elements of the second half list.
		for (int i = 0; i < listSize2; i++) {
			halfList2[i] = unsortedList[listSize1 + i];
		}

		// Recursively call this method with each individual halflist, making sure to pass in the alphabetical/reverse alphabetical preference that the user entered.
		halfList1 = mergeSort(halfList1, sortAlpha);
		halfList2 = mergeSort(halfList2, sortAlpha);

		// Merge both halflists together, ensuring that the alphabetical/reverse alphabetical preference of the user is also passed in.
		sortedList = merge(halfList1, halfList2, sortAlpha);

		// Return the sorted list.
		return sortedList;
		
	} // End of mergeSort method
} // End of MergeSort class
