import java.util.Scanner;

public class U3A7SimpleInvestment {

	private static final String InvestStr = null;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String invest1;
		String invest2;

		int investAmt1;
		String investStr;
		int investTrm1;

		String investTrmStr;

		int investAmt2;
		String investStr2;
		int investTrm2;

		String investTrmStr2;

		double interest1;
		double interest2;

		double total1;
		double total2;

		welcome();

		//user input

		System.out.println("Your Investments: ");

		System.out.print("  Investment #1 Type: ");

		invest1 = scan.nextLine();

		System.out.println(invest1);

		System.out.println("  Investment #1 Amnt: ");

		investStr = scan.nextLine();
		investAmt1 = Integer.parseInt(investStr);

		System.out.print("  Investment #1 Term (Years): ");

		investTrmStr = scan.nextLine();
		investTrm1 = Integer.parseInt(investTrmStr);

		System.out.print("  Investment #2 Type: ");
		invest2 = scan.nextLine();

		System.out.println("  Investment #2 Amnt: ");
		investStr2 = scan.nextLine();
		investAmt2 = Integer.parseInt(investStr2);

		System.out.println("  Investment #2 term: ");
		investTrmStr2 = scan.nextLine();
		investTrm2 = Integer.parseInt(investTrmStr2);


		interest1 = 0.05f;
		interest2 = 0.05f;

		if (investAmt1 > 1000) {
			interest1 = 0.1f;
		}

		if (investAmt1 > 5000) {
			interest1 = 0.15f;
		}

		if (investAmt2 > 1000) {
			interest2 = 0.1f;
		}

		if (investAmt2 > 5000) {
			interest2 = 0.15f;
		}

		if (investAmt1 > 10000) {
			interest1 = 0.2f;
			interest2 = 0.2f;
		}
		
		if (investAmt2 > 10000) {
			interest1 = 0.2f;
			interest2 = 0.2f;
		}

		if (investTrm1 >= 5) {
			interest1 = interest1 + 0.02f;
		}

		if (investTrm2 >= 5) 
		{
			interest2 = interest2 + 0.02f;
		}

		total1 = investAmt1 + (double)investAmt1 * interest1 * (double)investTrm1;
		total2 = investAmt2 + (double)investAmt2 * interest2 * (double)investTrm2;

		System.out.printf("%-25s %-25d %.2f\n",invest1,investAmt1,total1);
		System.out.printf("%-25s %-25d %.2f\n",invest2,investAmt2,total2);
		String(InvestStr, args);
	}

	private static void String(String investstr2, String[] args) {
		// TODO Auto-generated method stub

	}

	private static void welcome() {

		/* Add ASCII Art - DO this last */

		System.out.println(" Welcome to Annemary Investment");
		System.out.println("We Deliver the highest Rate of Return");
		System.out.println("");

	}
}
