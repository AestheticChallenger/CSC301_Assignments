
/**
 * Aysha Hira 1088000
 * Afrah Noor Salim 109111
 * Mehejat Jamal 1090225
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// import Assignment1.FinancialGoal;
import Exceptions.InvalidOptionSelectedException_Sec77_G7;
import Exceptions.LessThanZeroAmountFoundException_Sec77_G7;
import java.io.File;

public class BudgetMaster_Sec77_G7 {
	static Scanner input = new Scanner(System.in);
	static ArrayList<Transaction_Sec77_G7> transactionList = new ArrayList<>();

	// Array of created accounts of the user
	// static Account[] userAccounts = new Account[3];
	static Account_Sec77_G7 currentAccount = new Account_Sec77_G7("current Account");
	static Account_Sec77_G7 savingsAccount = new Account_Sec77_G7("saving Account");
	static Account_Sec77_G7 investmentAccount = new Account_Sec77_G7("investmentAccount");
	static Account_Sec77_G7[] userAccounts = { currentAccount, savingsAccount, investmentAccount };

	public static void main(String[] args) throws Exception {

		// java.io.File file = new java.io.File("txtFiles/f.txt");

		// // creates the file
		// if (file.createNewFile()) {
		// System.out.println("File created: " + file.getName());
		// }

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
					ExportFiles();
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
			System.out.print("Your Choice (0, 1, 2, 3, 4, 5, 6): ");
			choice = input.nextInt();
		} while (choice > 6);
		return choice;
	}

	public static void LogNewTransaction() {
		boolean setLoopCondition = true;

		String selectedAccount = "";

		// User selects the account they want to use
		while (setLoopCondition) {
			try {
				selectedAccount = chooseAccount();

				// For getting the index of the account chosen
				int index = getIndexOfTheTypeOfAccountFromUserAccountArray(selectedAccount);

				System.out.print("\nYou account balance is AED " + userAccounts[index].getBalance() + "\n");
				while (AddBalanceIfLessThanNegative(index)) {
					
							System.out.println(".\nPlease enter an amount to add: AED ");
					double balance = input.nextDouble();
					if (balance <= 0) {
						throw new IllegalArgumentException("The amount should be greater than 0. Please try again");
					}

					userAccounts[index].setBalance(balance);
					System.out.println("Amount added successfully. \nThe balance is AED : " + userAccounts[index].getBalance());

				}

				double amount = getAmount();

				String chosenType = "";
				// chosenType
				switch (selectedAccount.charAt(0)) {
					case 'C':
						// shows the aplicable type of transaction
						chosenType = getCurrentAccountTypesOfTransaction();
						break;

					case 'S':
						chosenType = getSavingsAccountTypesOfTransaction();
						break;

					case 'I':
						chosenType = getInvestmentAccountTypesOfTransaction();
						break;

				}

				String selectedCategory = "";
				switch (chosenType.substring(0, 3)) {
					case "EXP":
						selectedCategory = getSelectedExpenseCategory();
						break;

					case "INC":
						selectedCategory = getSelectedExpenseCategory();
						break;

					case "INV":
						selectedCategory = getSelectedExpenseCategory();
						break;

				}

				// Date
				LocalDate date = getOrUpdateDate();

				// Notes
				String userNotes = getTransactionNotes();

				Transaction_Sec77_G7 confirmedTransaction = null;
				// Confirmation & Adding to ArrayList
				switch (chosenType.substring(0, 3)) {
					case "EXP":
						confirmedTransaction = expenseConfirmationMessage(selectedAccount, amount, chosenType, selectedCategory,
								date, userNotes);
						break;

					case "INC":
						confirmedTransaction = incomeConfirmationMessage(selectedAccount, amount, chosenType, selectedCategory,
								date, userNotes);
						break;

					case "INV":
						confirmedTransaction = investmentConfirmationMessage(selectedAccount, amount, chosenType, selectedCategory,
								date, userNotes);
						break;

				}

				if (selectedCategory == "Income") {
					Account_Sec77_G7 account = userAccounts[index];
					account.setBalance(account.getBalance() + amount);

				} else {
					Account_Sec77_G7 account = userAccounts[index];
					account.setBalance(account.getBalance() - amount);
				}

				transactionList.add(confirmedTransaction);
				System.out.println(createExpenseTransaction());

				// Catches if the user inputed incorrect options
			} catch (InvalidOptionSelectedException_Sec77_G7 ex) {
				System.out.println(ex.getMessage());

			} catch (LessThanZeroAmountFoundException_Sec77_G7 ex) {
				System.out.println(ex.getMessage());

			} catch (InputMismatchException ex) {
				System.out.println("Invalid input, please enter a number.");
			}

		}

	}

	// Mehejat's Part!!
	public static void UpdateTransaction() {
		try {

			UpdateTransactions_Sec77_G7.updateTransactionMainMenu();

		} catch (InvalidOptionSelectedException_Sec77_G7 ex) {
			System.out.println(ex.getMessage());

		} 
		
		// To be completed. Feel free to change the input parameters.
	}

	// Afrah's Part!!
	public static void SetUpdateBudgetLimits() {
		// To be completed. Feel free to change the input parameters.

		Budget_Sec77_G7 budget = new Budget_Sec77_G7();
		budget.budgetmenu();
	}

	public static void TrackProgress(){
	      // Display the menu
        System.out.println("\n--- Track Progress Menu ---");
        System.out.println("1. Track Budget Progress");
        System.out.println("2. Track Financial Goals");
		System.out.println();
		int choice1=input.nextInt();
		if(choice1==1) {
			System.out.println("enter the category to see the progress");
			String category=input.next();
		 Budget_Sec77_G7 budget1=new Budget_Sec77_G7(); 
		budget1.getProgress();
		}
		if(choice1==2) {
			//if(!isSet)
			System.out.println("Enter the Year");
			int year=input.nextInt();
			System.out.println("Enter the Month");
			int month=input.nextInt();
			System.out.println("Enter the Day");
			int day=input.nextInt();
			System.out.println("Enter the Target Amount");
			int targetamount=input.nextInt();
			FinancialGoals_Sec77_G7 financialgoal=new FinancialGoals_Sec77_G7(year,month,day,targetamount);
			financialgoal.getProgress();
		}
			
		}

	// Mehejat's Part!!
	public static void GenerateFinancialReports() {
		FinancialReport.generateFinancialReport();
	}

	// Aysha's Part!! CHECK!!!!
	public static void ExportFiles() {
		try (java.io.PrintWriter writer = new java.io.PrintWriter("f.txt")) {
			
				for (Transaction_Sec77_G7 transaction : transactionList) {
					// Assuming Transaction has appropriate getters to access its data
					writer.println(transaction.getReferenceID() + "," + 
							transaction.getAccountName() + ", " + // Account type
							transaction.getAmount() + "," + // Amount
							// transaction.getCategory() + "," + // Transaction type
							transaction.getCategory() + "," + // Category
							transaction.getDate() + "," + // Date
							transaction.getNotes()); // Notes
				}
			
	// 		System.out.println("Data successfully written to the file: " + file.getName());
		} catch (Exception e) {
			System.out.println("An error occurred while writing to the file: " + e.getMessage());
		}
	}

	public static String chooseAccount() throws InvalidOptionSelectedException_Sec77_G7 {
		boolean setloop = true;
		String choosenAccount = "";
		while (setloop) {
			String confirmation = "";
			System.out
					.print("\n1. Current Account \n2. Savings Account \n3. Investment Account \nPlease choose your account: ");
			char userInput = input.next().toUpperCase().trim().charAt(0);
			switch (userInput) {
				case '1':
				case 'C':
					System.out.print("You have selected: Current Account. \nDo you confirm? (yes/no): ");
					confirmation = input.next().toLowerCase();
					if (confirmation.charAt(0) == 'y') {
						choosenAccount = "Current Account";
						setloop = false;
					}
					break;

				case '2':
				case 'S':
					System.out.print("You have selected: Savings Account. \nDo you confirm? (yes/no): ");
					confirmation = input.next().toLowerCase();
					if (confirmation.charAt(0) == 'y') {
						choosenAccount = "Savings Account";
						setloop = false;
					}
					break;

				case '3':
				case 'I':
					System.out.print("You have selected: Investment Account. \nDo you confirm? (yes/no): ");
					confirmation = input.next().toLowerCase();
					if (confirmation.charAt(0) == 'y') {
						choosenAccount = "Investment Account";
						setloop = false;
					}
					break;

				default:
					throw new InvalidOptionSelectedException_Sec77_G7();
			}
		}
		return choosenAccount;
	}

	public static double getAmount() throws LessThanZeroAmountFoundException_Sec77_G7 {
		double amount = 0;
		do {
			try {
				System.out.print("\nEnter the amount to log the transaction: ");
				amount = input.nextDouble();

				// Check if the amount is positive
				if (amount <= 0) {
					throw new LessThanZeroAmountFoundException_Sec77_G7();
				}
			} catch (InputMismatchException ex) {
				System.out.println(ex.getMessage());
			}

		} while (!confirmInput("AED " + Double.toString(amount)));

		return amount;
	}

	public static LocalDate getOrUpdateDate() {
		LocalDate chosenDate = null;
		boolean setloop = true;

		while (setloop) {
			System.out.println("Please enter the date in the following format.");
			System.out.print("Please enter the year: ");
			int choosenYear = input.nextInt();

			System.out.print("Please enter the month (1-12): ");
			int choosenMonth = input.nextInt();

			System.out.print("Please enter the day: ");
			int choosenDay = input.nextInt();

			// Create LocalDate object from user input
			try {
				chosenDate = LocalDate.of(choosenYear, choosenMonth, choosenDay);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String formattedDate = chosenDate.format(formatter);
				if (confirmInput(formattedDate)) {
					setloop = false;
				}

			} catch (Exception e) {
				System.out.println("Invalid date input: " + e.getMessage());
			}
		}

		return chosenDate;
	}

	public static String getTransactionNotes() {
		String notes = "";

		do {
			System.out.println("Please enter here any notes/details you wan to add: ");
			notes = input.next().trim();
			notes += input.nextLine();
		} while (!confirmInput("\n\n" + notes + "\n"));

		return notes;
	}

	// Shows the confirmation message unique for each type
	public static Transaction_Sec77_G7 expenseConfirmationMessage(String selectedAccount, double amount, String chosenType,
			String choosenCategory, LocalDate date, String userNotes) {
		String location = Expense_Sec77_G7.getLocation();
		String referenceID = "";
		System.out.println("Account selected: " + selectedAccount
				+ "\nAmount: AED" + amount
				+ "\nType Of Transaction: " + chosenType
				+ "\nCategory: " + choosenCategory
				+ "\nDate: " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ "\nNotes: " + userNotes
				+ "\nLocation: " + location
				+ "\nDo you confirm? [yes/no]");

		String confirmation = input.next().trim().toUpperCase();

		if (confirmation.charAt(0) != 'Y' ? true : false) {
			System.out.println("The transaction has been deleted. \nReturning to the main menu...");
			DislayMenu();
		}

		else {
			referenceID = "EXP" + ((int) (Math.random() * 100000) - 10000);
			System.out.println("The transaction Reference ID: " + referenceID);
		}

		return new Expense_Sec77_G7(referenceID, amount, selectedAccount, choosenCategory,
				choosenCategory, userNotes, location);

	}

	// Shows the confirmation message unique for each type
	public static Transaction_Sec77_G7 incomeConfirmationMessage(String selectedAccount, double amount, String chosenType,
			String choosenCategory, LocalDate date, String userNotes) {
		String referenceID = "";
		System.out.println("Account selected: " + selectedAccount
				+ "\nAmount: AED" + amount
				+ "\nType Of Transaction: " + chosenType
				+ "\nSource: " + choosenCategory
				+ "\nDate: " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ "\nNotes: " + userNotes
				+ "\nDo you confirm? [yes/no]");

		String confirmation = input.next().trim().toUpperCase();

		if (confirmation.charAt(0) != 'Y' ? true : false) {
			System.out.println("The transaction has been deleted. \nReturning to the main menu...");
			DislayMenu();
		}

		else {
			referenceID = "INC" + ((int) (Math.random() * 100000) - 10000);
			System.out.println("The transaction Reference ID: " + referenceID);  
		}

		return new Income_Sec77_G7(referenceID, amount,
				selectedAccount, choosenCategory,
				choosenCategory, userNotes);

	}

	public static Transaction_Sec77_G7 investmentConfirmationMessage(String selectedAccount, double amount, String chosenType,
			String choosenCategory, LocalDate date, String userNotes) throws InvalidOptionSelectedException_Sec77_G7 {
		String payment = Investment_Sec77_G7.getPaymentMethod();
		String referenceID = "";
		System.out.println("Account selected: " + selectedAccount
				+ "\nAmount: AED" + amount
				+ "\nType Of Transaction: " + chosenType
				+ "\nCategory: " + choosenCategory
				+ "\nDate: " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
				+ "\nNotes: " + userNotes
				+ "\nPayment Method: " + payment
				+ "\nDo you confirm? [yes/no]");

		String confirmation = input.next().trim().toUpperCase();

		if (confirmation.charAt(0) != 'Y' ? true : false) {
			System.out.println("The transaction has been deleted. \nReturning to the main menu...");
			DislayMenu();
		}

		else {
			referenceID = "INV" + ((int) (Math.random() * 100000) - 10000);
			System.out.println("The transaction Reference ID: " + referenceID); 
		}

		return new Expense_Sec77_G7(referenceID, amount,
				selectedAccount, choosenCategory,
				choosenCategory, userNotes, payment);

	}

	public static boolean AddBalanceIfLessThanNegative(int index) {
		return userAccounts[index].getBalance() <= 0 ? true : false;
	}

	// DO IT NOW
	public static void writeFile(File file) {
		// Writes from arraylist to a file
	}

	// DO IT NOW
	public static void readFile(File file) {

	}

	public static int getIndexOfTheTypeOfAccountFromUserAccountArray(String selectedAccount) {
		int index = -1;
		switch (selectedAccount.charAt(0)) {
			case 'C':
				index = 0;
				break;

			case 'S':
				index = 1;

				break;

			case 'I':
				index = 2;
				break;
		}
		return index;
	}

	public static boolean confirmInput(String userInput) {
		boolean confirmation = false;
		System.out.println("You entered: " + userInput + "\nDo you confirm? (yes/no): ");
		String userConfirmation = input.next().toLowerCase();
		if (userConfirmation.charAt(0) == ('y')) {
			confirmation = true;
		}
		return confirmation;
	}

	public static String getCurrentAccountTypesOfTransaction() throws InvalidOptionSelectedException_Sec77_G7 {
		boolean setLoop = true;
		String chosenType = "";
		while (setLoop) {
			System.out.print("\n1. Expense " // vat
					+ "\n2. Income" // source
					+ "\nEnter the first letter of the type of transaction: ");
			chosenType = input.next().trim().toUpperCase();

			try {
				switch (chosenType.charAt(0)) {
					case 'E':
						chosenType = "Expense";

						break;

					case 'I':
						chosenType = "Income";
						setLoop = false;
						break;

					default:
						throw new InvalidOptionSelectedException_Sec77_G7();
				}

				if (confirmInput(chosenType)) {
					setLoop = false;
				}
			} catch (InvalidOptionSelectedException_Sec77_G7 ex) {
				System.out.println(ex.getMessage());
			}

		}

		return chosenType.toUpperCase();
	}

	public static String getSavingsAccountTypesOfTransaction() throws InvalidOptionSelectedException_Sec77_G7 {
		boolean setLoop = true;
		while (setLoop) {

		}
		System.out.print("\n1. Income" // source
				+ "\n2. Transfer" // recieverAccount
				+ "\nEnter the number or the first letter of the type of transaction: ");
		String chosenType = input.next().trim().toUpperCase();

		switch (chosenType.charAt(0)) {
			case '1':
			case 'I':
				chosenType = "Income";
				setLoop = false;
				break;

			case '2':
			case 'T':
				chosenType = "Transfer";
				setLoop = false;
				break;

			default:
				throw new InvalidOptionSelectedException_Sec77_G7();
		}

		return chosenType.toUpperCase();
	}

	public static String getInvestmentAccountTypesOfTransaction() throws InvalidOptionSelectedException_Sec77_G7 {
		boolean setLoop = true;
		while (setLoop) {

		}
		System.out.print("\n1. Income" // source
				+ "\n2. Investment" // recieverAccount
				+ "\nEnter the number next to the type of transaction: ");
		String chosenType = input.next().trim();

		switch (Integer.parseInt(chosenType)) {
			case 1:
				chosenType = "Income";
				setLoop = false;
				break;

			case 2:
				chosenType = "Investment";
				setLoop = false;
				break;

			default:
				throw new InvalidOptionSelectedException_Sec77_G7();
		}

		return chosenType.toUpperCase();
	}

	public static String getSelectedExpenseCategory() throws InvalidOptionSelectedException_Sec77_G7 {
		System.out.println();
		Expense_Sec77_G7.viewExpenseCategories();

		System.out.print("\nPlease choose the number next to the category you want to select: ");
		int indexOfChoosenCategory = input.nextInt();

		if ((indexOfChoosenCategory > Expense_Sec77_G7.expenseCategories.length - 1) || indexOfChoosenCategory <= 0) {
			throw new InvalidOptionSelectedException_Sec77_G7();
		}

		return (String) (getElementByIndex(Expense_Sec77_G7.expenseCategories, indexOfChoosenCategory - 1));
	}

	public static String getSelectedIncomeCategory() throws InvalidOptionSelectedException_Sec77_G7 {
		System.out.println();
		Income_Sec77_G7.viewIncomeCategories();

		System.out.print("\nPlease choose the number next to the category you want to select: ");
		int indexOfChoosenCategory = input.nextInt();
		if ((indexOfChoosenCategory > Income_Sec77_G7.incomeCategories.length - 1) || indexOfChoosenCategory <= 0) {
			throw new InvalidOptionSelectedException_Sec77_G7();
		}
		return (String) (getElementByIndex(Income_Sec77_G7.incomeCategories, indexOfChoosenCategory - 1));
	}

	public static String getSelectedInvestmentCategory() throws InvalidOptionSelectedException_Sec77_G7 {
		System.out.println();
		Investment_Sec77_G7.viewInvestmentCategories();

		System.out.print("\nPlease choose the number next to the category you want to select: ");
		int indexOfChoosenCategory = input.nextInt();
		if ((indexOfChoosenCategory > Investment_Sec77_G7.investmentCategories.length - 1) || indexOfChoosenCategory <= 0) {
			throw new InvalidOptionSelectedException_Sec77_G7();
		}
		return (String) (getElementByIndex(Investment_Sec77_G7.investmentCategories, indexOfChoosenCategory - 1));
	}

	public static Object getElementByIndex(Object[] array, int index) {
		for (Object row : array) {
			return row;
		}
		return null;
	}






// DELETEEEE








	public static String createExpenseTransaction() {
		for (Transaction_Sec77_G7 transaction : transactionList) {

			return transaction.toString();
		}

		return "";
	}

	public static void printTransactionsDetailsMenu() throws InvalidOptionSelectedException_Sec77_G7 {
		System.out.print("\n1. Amount"
				+ "\n2. Date"
				+ "\n3. Category"
				+ "\n4. Notes"
				+ "\nPlease select the number next to the option that you want to change: ");

		String option = input.next().trim().toUpperCase();

		switch (option.charAt(0)) {
			case '1':
			case 'A':

				break;

			case '2':
			case 'D':

				break;

			case '3':
			case 'C':

				break;

			case '4':
			case 'N':

				break;

			default:
				break;
		}

		
	}

}
