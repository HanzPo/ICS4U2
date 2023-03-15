import javax.swing.JOptionPane;

public class TestMethods {

	public static void main(String[] args) {

		int firstNumber = 0;
		int secondNumber = 0;
		
		firstNumber = getNumber();
		secondNumber = getNumber();
		
		displayIt(firstNumber);
		displayItTimesTwo(firstNumber);
		displayItPlusOneHundred(firstNumber);
		
		displayIt(secondNumber);
		displayItTimesTwo(secondNumber);
		displayItPlusOneHundred(secondNumber);
		
		System.exit(0);
	}
	
	public static int getNumber() {
		int num = 0;
		
		num = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter a whole number"));
		
		return num;
	}

	public static void displayIt(int num) {
		JOptionPane.showMessageDialog(null, num, "Number", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void displayItTimesTwo(int num) {
		JOptionPane.showMessageDialog(null, num * 2, "Number", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void displayItPlusOneHundred(int num) {
		JOptionPane.showMessageDialog(null, num + 100, "Number", JOptionPane.PLAIN_MESSAGE);
	}
}
