
/**
 * Aysha Hira 1088000
 * Afrah Noor Salim 109111
 * Mehejat Jamal 1090225
 */

import java.util.InputMismatchException;
import java.util.Scanner;

import Exceptions.InvalidOptionSelectedException_Sec77_G7;

public class Investment_Sec77_G7 extends Transaction_Sec77_G7 {

  static Scanner input = new Scanner(System.in);

  String paymentMethod;

  static String[] investmentCategories = { "Stocks", "Bonds", "Real Estate" };

  Investment_Sec77_G7(String referenceID, double amount, String accountName, String transactionType, String category,
      String date, String notes, String paymentMethod) {
    super(referenceID, amount, accountName, category, date, notes);
    this.paymentMethod = paymentMethod;
  }

  

  public static void viewInvestmentCategories() {
    for (int index = 0; index < investmentCategories.length; index++) {
      System.out.println((index + 1) + ". " + investmentCategories[index]);
    }

  }

  public static String getPaymentMethod() throws InputMismatchException, InvalidOptionSelectedException_Sec77_G7 {
    String paymentMethod = "";
    do {
      try {
        System.out.print("\n1. Credit Card"
            + "\n2. Cryptocurrency"
            + "\n3. Cash"
            + "\n4. Debit Card"
            + "\n5. Bank Transfer"
            + "\n6. Others"
            + "\n Please select the number next to the payment method: ");
        int option = input.nextInt();

        switch (option) {
          case 1:
            paymentMethod = "Credit Card";
            break;

          case 2:
            paymentMethod = "Cryptocurrency";
            break;

          case 3:
            paymentMethod = "Cash";
            break;

          case 4:
            paymentMethod = "Debit Card";
            break;

          case 5:
            paymentMethod = "Bank Transfer";
            break;

          case 6:
            paymentMethod = "Others";
            break;

          default:
            throw new InvalidOptionSelectedException_Sec77_G7();

        }

      } catch (InputMismatchException e) {
        System.out.println(e.getMessage());

      } catch (InvalidOptionSelectedException_Sec77_G7 e) {
        System.out.println(e.getMessage());

      }

    } while (!BudgetMaster_Sec77_G7.confirmInput(paymentMethod));
    return paymentMethod;
  }


}