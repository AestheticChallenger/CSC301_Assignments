/**
 * Aysha Hira 1088000
 * Afrah Noor Salim 109111
 * Mehejat Jamal 1090225
 */

public class Expense_Sec77_G7 extends Transaction_Sec77_G7 {

  static String[] expenseCategories = { "Food",
      "Groceries",
      "Utilities",
      "Rent",
      "Transport",
      "Miscellaneous" };

  String location;

  Expense_Sec77_G7(String referenceID, double amount,
      String accountName, String category, String date, String notes, String location) {
    super(referenceID, amount, accountName, category, date, notes);
    this.location = location;
  }

  public static void viewExpenseCategories() {
    for (int index = 0; index < expenseCategories.length; index++) {
      System.out.println((index + 1) + ". " + expenseCategories[index]);

    }

  }

  public static String getLocation() {
    boolean setLoop = true;
    String location = "";

    while (setLoop) {
      System.out.print("\nPlease enter the location of the expense (XX Mall, YY Library, etc.): ");
      location = BudgetMaster_Sec77_G7.input.next().trim().toUpperCase();
      if (BudgetMaster_Sec77_G7.confirmInput(location)) {
        setLoop = false;
      }

    }

    return location;
  }
}
