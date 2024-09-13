import java.util.Scanner;

public class BudgetMaster {
	public static void main(String[] args) {
	
		int userChoice;
		do {
			DislayMenu();
			userChoice = UserMenuChoice();
			switch (userChoice) {
				case 1: LogNewTransaction(); break; 	
				case 2: UpdateTransaction(); break;	
				case 3: SetUpdateBudgetLimits(); break;	
				case 4: TrackProgress(); break;		
				case 5: GenerateFinancialReports(); break;	
				case 6: NewExtraFunctionality(); break;	

				default:  System.out.println("Thank You for Using CSC301's BudgetMaster™ (Your Personal Finance Manager), See You Again.");
			}
		}while (userChoice != 0);
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

	public static int UserMenuChoice(){
		Scanner input = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Your Choice (0, 1, 2, 3, 4, 5, 6):");
			choice = input.nextInt();
		} while(choice > 6);
		return choice;
	}
	
	public static void LogNewTransaction(){
		// To be completed. Feel free to change the input parameters. 
	}

	public static void UpdateTransaction(){
		// To be completed. Feel free to change the input parameters.  
	}

	public static void SetUpdateBudgetLimits(){
		// To be completed. Feel free to change the input parameters.  
	}

	public static void TrackProgress(){
		// To be completed. Feel free to change the input parameters. 
	}
	
	public static void GenerateFinancialReports(){
		// To be completed. Feel free to change the input parameters. 
	}

	public static void NewExtraFunctionality(){
		// To be completed. Feel free to change the input parameters. 
	}
}
