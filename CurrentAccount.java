import java.util.ArrayList;
import java.util.Scanner;

public class CurrentAccount {
  private double balance;

  static Scanner input = new Scanner(System.in);

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public static void main(String[] args) {
    boolean setLoopCondition = true;
    ArrayList<Object> transactionRow = new ArrayList<>();

    try {
      // selectedAccount = chooseAccount();

      System.out.println("Enter the amount: ");
      double amount = input.nextDouble();

      // Check if the amount is positive
      if (amount <= 0) {
        throw new LessThanZeroAmountFoundException();
      }

      System.out.println("Enter the type of transaction: "
          + "\n1. Expense "
          + "\n2. Income"
          + "\n3. Transfer");

          

      // Catches if the user inputed incorrect options
      // } catch (InvalidOptionSelectedException ex) {
      // System.out.println(ex.getMessage());

      // Catches if the amount is positive
    } catch (LessThanZeroAmountFoundException m) {
      System.out.println(m.getMessage());

    }

  }

}
