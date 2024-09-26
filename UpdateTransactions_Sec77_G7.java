
/**
 * Aysha Hira 1088000
 * Afrah Noor Salim 109111
 * Mehejat Jamal 1090225
 */

import java.time.LocalDate;
import java.util.Scanner;


import Exceptions.InvalidOptionSelectedException_Sec77_G7;
import Exceptions.LessThanZeroAmountFoundException_Sec77_G7;

public class UpdateTransactions_Sec77_G7 {

  public static void updateTransactionMainMenu() throws InvalidOptionSelectedException_Sec77_G7 {
    System.out.println("\nSearch by:"
        + "1. Referance ID"
        + "2. Category");
    String selection = input.next().trim().toUpperCase();

    switch (selection.charAt(0)) {
      case 'R':
      case '1':
        searchByReferenceID();
        break;

      case 'C':
      case '2':
        showAllCategories();
        break;

      default:
        break;
    }
  }

  static Scanner input = new Scanner(System.in);

  public static void searchByReferenceID() throws InvalidOptionSelectedException_Sec77_G7 {
    System.out.print("\nEnter your Transaction ID: ");
    String transID = input.next().trim().toUpperCase();
    if (checkIfTransactionExists(transID)) {
      getTransaction(transID);
    }
  }

  // gets the transaction
  public static Transaction_Sec77_G7 getTransaction(String referenceID) {
    Transaction_Sec77_G7 returnTransaction = null;
    for (Transaction_Sec77_G7 transaction : BudgetMaster_Sec77_G7.transactionList) {
      if (transaction.getReferenceID() == referenceID) {
        return transaction;
      }
    }

    return returnTransaction;
  }

  public static boolean checkIfTransactionExists(String referenceID) {
    boolean result = false;
    for (Transaction_Sec77_G7 transaction : BudgetMaster_Sec77_G7.transactionList) {
      if (transaction.getReferenceID() == referenceID) {
        return true;
      }
    }

    return result;
  }

  public static void showAllCategories() throws InvalidOptionSelectedException_Sec77_G7{

    String category = "";
    for (int i = 0; i < Expense_Sec77_G7.expenseCategories.length; i++) {
      System.out.println(i + ". " + Expense_Sec77_G7.expenseCategories[i]);
    }

    for (int i = 7; i < Income_Sec77_G7.incomeCategories.length + 7; i++) {
      System.out.println(i + ". " + Income_Sec77_G7.incomeCategories[i - 7]);
    }

    for (int i = 10; i < Investment_Sec77_G7.investmentCategories.length + 10; i++) {
      System.out.println(i + ". " + Income_Sec77_G7.incomeCategories[i - 10]);
    }

    System.out.println("\nPlease select the number next to the category: ");
    int option = input.nextInt();

    switch (option) {
      case 1:
      category = "Food";
        break;

      case 2:
 category = "Groceries";
        break;

      case 3:
        category = "Utilities";
        break;

      case 4:
        category = "Rent";
        break;

      case 5:
        category = "Transport";
        break;

      case 6:
        category = "Miscellaneous";
        break;

      case 7:
        category = "Groceries";
        break;

      case 8:
        category = "Part-time job";
        break;

      case 9:
        category = "Others";
        break;

      case 10:
        category = "Stocks";
        break;

      case 11:
        category = "Bonds";
        break;

      case 12:
        category = "Real Estate";
        break;

      default:
      throw new InvalidOptionSelectedException_Sec77_G7();
    }

    searchByCategory(category.toUpperCase());

  }

  public static void searchByCategory(String category) throws InvalidOptionSelectedException_Sec77_G7 {
    for (Transaction_Sec77_G7 transaction : BudgetMaster_Sec77_G7.transactionList) {
      if (transaction.getCategory() == category) {
        System.out.println(transaction.toString());
      }
    }

    searchByReferenceID();
  }

  public static void printTransactionsDetailsMenu(Transaction_Sec77_G7 transaction)
      throws InvalidOptionSelectedException_Sec77_G7, LessThanZeroAmountFoundException_Sec77_G7 {
    System.out.print("\n1. Amount"
        + "\n2. Date"
        + "\n3. Category"
        + "\n4. Notes"
        + "\nPlease select the number next to the option that you want to change: ");

    String option = input.next().trim().toUpperCase();

    switch (option.charAt(0)) {
      case '1':
      case 'A':
        transaction.setAmount(BudgetMaster_Sec77_G7.getAmount());
        break;

      case '2':
      case 'D':
        LocalDate date = BudgetMaster_Sec77_G7.getOrUpdateDate();
        // transaction.setDate(date);
        break;

      case '3':
      case 'C':
        switch (transaction.getReferenceID().substring(0, 3)) {
          case "EXP":
            transaction.setCategory(BudgetMaster_Sec77_G7.getSelectedExpenseCategory());
            break;

          case "INC":
            transaction.setCategory(BudgetMaster_Sec77_G7.getSelectedIncomeCategory());
            break;

          case "INV":
            transaction.setCategory(BudgetMaster_Sec77_G7.getSelectedInvestmentCategory());
            break;
        }

        break;

      case '4':
      case 'N':
        transaction.setNotes(BudgetMaster_Sec77_G7.getTransactionNotes());
        break;

      default:
        throw new InvalidOptionSelectedException_Sec77_G7();
    }
  }

}
