import javax.swing.JOptionPane;

public class Eggs {

	public static void main(String[] args) {
		int numberOfEggs = 0;

		numberOfEggs = getEggs();
		calculateDozens(numberOfEggs);
		
		System.exit(0);
	}

	public static int getEggs() {
		int eggCount = Integer.parseInt(JOptionPane.showInputDialog(null, "How many eggs do you have?"));
		return eggCount;
	}
	
	public static void calculateDozens(int eggCount) {
		int dozenCount = eggCount / 12;
		int eggsLeft = eggCount % 12;
		
		JOptionPane.showMessageDialog(null, eggCount + " is " + dozenCount + " full dozens, with " + eggsLeft + " eggs remaining", "Dozens", JOptionPane.PLAIN_MESSAGE);
	}
}
