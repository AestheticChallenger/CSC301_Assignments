
import java.util.ArrayList;
import java.util.Scanner;

public class SavingsAccount {
  private double balance;

  static Scanner input = new Scanner(System.in);

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public static void main(String[] args) throws Exception {
    boolean setLoopCondition = true;
    ArrayList<Object> transactionRow = new ArrayList<>();

    // selectedAccount = chooseAccount();

    System.out.println("Enter the amount: ");
    double amount = input.nextDouble();

    // Check if the amount is positive
    if (amount <= 0) {
      throw new LessThanZeroAmountFoundException();
    }

    System.out.println("Enter the type of transaction: "
        + "\n1. Transfer "
        + "\n2. Income");

    char transactionType = input.next().toUpperCase().trim().charAt(0);

    switch (transactionType) {
      case '1':
      case 'T':
      
        break;

      case '2':
      case 'I':

        break;

      default:
        throw new InvalidOptionSelectedException();

    }

  }

}
