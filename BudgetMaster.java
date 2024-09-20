import java.util.ArrayList;
import java.util.Scanner;

public class BudgetMaster {
	static Scanner input = new Scanner(System.in);
	static ArrayList<ArrayList<Transaction>> transactionList = new ArrayList<>();

	// Array of created accounts of the user
	static Account[] userAccounts = new Account[3];

	public static void main(String[] args) throws Exception{
		
		java.io.File file = new java.io.File("txtFiles/f.txt");
		
		// creates the file
		if (file.createNewFile()) {
		System.out.println("File created: " + file.getName());
		}
		
		
		
		int userChoice;
		do {
			DislayMenu();
			userChoice = UserMenuChoice();
			switch (userChoice) {
				case 1:
					LogNewTransaction();
					break;
				case 2:
					UpdateTransaction();
					break;
				case 3:
					SetUpdateBudgetLimits();
					break;
				case 4:
					TrackProgress();
					break;
				case 5:
					GenerateFinancialReports();
					break;
				case 6:
					NewExtraFunctionality();
					break;

				default:
					System.out
							.println("Thank You for Using CSC301's BudgetMaster™ (Your Personal Finance Manager), See You Again.");
			}
		} while (userChoice != 0);
	}

	public static void DislayMenu() {
		System.out.println("------------------------------------------------------------");
		System.out.println("Personal Finance Manager System (BudgetMaster™), Fall 24-25");
		System.out.println("------------------------------------------------------------");
		System.out.println("1. Log a new transaction (Income, Expense, Transfer, etc.)");
		System.out.println("2. Update transaction details (amount, category, date, notes, etc.)");
		System.out.println("3. Set or update budget limits for various categories.");
		System.out.println("4. Track progress towards budget goals and financial objectives.");
		System.out.println("5. Generate financial reports (monthly, quarterly, annual, etc.)");
		System.out.println("6. NEW extra functionality of your choice. BE INNOVATIVE.");
		System.out.println("0. Exit");
		System.out.println("------------------------------------------------------------");
	}

	public static int UserMenuChoice() {
		int choice;
		do {
			System.out.println("Your Choice (0, 1, 2, 3, 4, 5, 6):");
			choice = input.nextInt();
		} while (choice > 6);
		return choice;
	}

	public static void LogNewTransaction() throws Exception {
		// To be completed. Feel free to change the input parameters.

		boolean setLoopCondition = true;
		ArrayList<Object> transactionRow = new ArrayList<>();

		String selectedAccount = "";

		// User selects the account they want to use
		while (setLoopCondition) {
			try {
				selectedAccount = chooseAccount();
				
				switch (selectedAccount) {
					case "currentAccount":
						CurrentAccount.main(null);
						break;

					case "savingAccount":
						SavingsAccount.main(null);
						break;

					case "investmentAccount":
						InvestmentAccount.main(null);
						break;
				}

				// Catches if the user inputed incorrect options
			} catch (InvalidOptionSelectedException ex) {
				System.out.println(ex.getMessage());

				// Catches if the amount is positive
			}

		}

	}

	// Mehejat's Part!!
	public static void UpdateTransaction() {

		// To be completed. Feel free to change the input parameters.
	}

	// Afrah's Part!!
	public static void SetUpdateBudgetLimits() {
		// To be completed. Feel free to change the input parameters.
	}

	// Afrah's Part!!
	public static void TrackProgress() {
		// To be completed. Feel free to change the input parameters.
	}

	// Mehejat's Part!!
	public static void GenerateFinancialReports() {

		// To be completed. Feel free to change the input parameters.
	}

	// Aysha's Part!!
	public static void NewExtraFunctionality() {
		// To be completed. Feel free to change the input parameters.
	}

	public static String chooseAccount() throws InvalidOptionSelectedException {
		String choosenAccount = "";
		System.out.print("1. Current Account \n2. Savings Account \n3. Investment Account \nPlease choose your account: ");
		char userInput = input.next().toUpperCase().trim().charAt(0);
		switch (userInput) {
			case '1':
			case 'C':
				choosenAccount = "CurrentAccount";
				break;

			case '2':
			case 'S':
				choosenAccount = "SavingsAccount";
				break;

			case '3':
			case 'I':
				choosenAccount = "InvestmentAccount";
				break;

			default:
				throw new InvalidOptionSelectedException();
		}

		return choosenAccount;
	}

	/** Searches and displays record(s) in an arrayList that contains a specific
	 * word/ object
	 * Put try and catch here!!!!!!!!!
	 */
	// public static void printRows(int index, Object itemToSearch) {
	// 	for (ArrayList<Object> row : transactionList) {
	// 		if (row.get(index) == itemToSearch) {
	// 			System.out.println(row);

	// 		}

	// 	}

	// }

	public static int getIndexOf(int columnIndex, Object itemToSearch) {
		int rowIndex = -1;
		for (int i = 0; i < transactionList.size(); i++) {
			if (transactionList.get(i).get(columnIndex) == itemToSearch) {
				rowIndex = i;

			}

		}
		return rowIndex;

	}

	public void viewTransactionType(String transactionType) {

	}
}
