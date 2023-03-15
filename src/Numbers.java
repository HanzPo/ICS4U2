import javax.swing.JOptionPane;

public class Numbers {

	public static void main(String[] args) {
		int firstNumber = 0;
		int secondNumber = 0;

		firstNumber = getNumber();
		secondNumber = getNumber();
		
		sum(firstNumber, secondNumber);
		difference(firstNumber, secondNumber);
		
		JOptionPane.showMessageDialog(null, "The product is: " + product(firstNumber, secondNumber), "Product", JOptionPane.PLAIN_MESSAGE);
		
		System.exit(0);
		
	}

	public static int getNumber() {
		int num = 0;
		
		num = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter a whole number"));
		
		return num;
	}
	
	public static void sum(int num1, int num2) {
		int finalSum = num1 + num2;
		
		JOptionPane.showMessageDialog(null, "The sum is: " + finalSum, "Sum", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void difference(int num1, int num2 ) {
		int finalDifference = num1 - num2;
		
		
		JOptionPane.showMessageDialog(null, "The difference is: " + Math.abs(finalDifference), "Difference", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static int product(int num1, int num2) {
		return num1 * num2;
	}
}
