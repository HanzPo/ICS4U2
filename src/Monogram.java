import javax.swing.JOptionPane;

public class Monogram {
	public static void main(String[] args) {
		
		int choice = 0;
		
		char first = ' ';
		char middle = ' ';
		char last = ' ';
		
		first = getChar("Please enter your first initial");
		middle = getChar("Please enter your middle initial");
		last = getChar("Please enter your last initial");
	
		choice = JOptionPane.showConfirmDialog(null, "Would you like to enter in traditional monogram style?", "Message", JOptionPane.YES_NO_OPTION);
		
		if (choice == 0) {
			printChar(first, last, middle);
		}
		else {
			printChar(first, middle, last);
		}
		
		System.exit(0);
	}
	
	public static char getChar(String prompt) {
		String character = JOptionPane.showInputDialog(null, prompt);
		character.toUpperCase();
		
		return character.charAt(0);
	}
	
	public static void printChar(char character1, char character2, char character3) {
		JOptionPane.showMessageDialog(null, character1 + ". " + character2 + ". " + character3);
	}
}
