// package Account;
// import java.util.ArrayList;
// import java.util.Scanner;

// import Budget;
// import Calendar;
// import Exceptions.InvalidOptionSelectedException;
// import Exceptions.LessThanZeroAmountFoundException;

// public class CurrentAccount {
//   private double balance;

//   static Scanner input = new Scanner(System.in);

//   public void setBalance(double balance) {
//     this.balance = balance;
//   }

//   public double getBalance() {
//     return balance;
//   }

//   public static void main(String[] args) {
//     ArrayList<Object> transactionRow = new ArrayList<>();

//     try {
//       System.out.print("Enter the amount: ");
//       double amount = input.nextDouble();

//       // Check if the amount is positive
//       if (amount <= 0) {
//         throw new LessThanZeroAmountFoundException();
//       }

//       System.out.print("\n1. Expense "
//           + "\n2. Income"
//           + "\n3. Transfer"
//           + "\nEnter the type of transaction: ");
//       int choosenType = input.nextInt();
//       if (choosenType > 3 && choosenType < 1) {
//         throw new InvalidOptionSelectedException();
//       }

//       Budget.viewAllCategories();
//       System.out.print("Please choose the number next to the category you want to select: ");
//       int choosenCategory = input.nextInt();


//       // Date 
//       System.out.println("Please enter the date in the following format."
//           + "\nPlease enter the year: ");
//       int choosenYear = input.nextInt();

//       System.out.print("Please enter the month: ");
//       int choosenMonth = input.nextInt();

//       System.out.print("Please enter the day: ");
//       int choosenDay = input.nextInt();
//       Calendar date = new Calendar(choosenYear, choosenMonth, choosenDay);

//       // Notes
//       System.out.println("Please enter here any notes/details you wan to add: ");
//       String userNotes = input.next().trim();
//       userNotes += input.nextLine();

      

//       // Catches if the user inputed incorrect options
//     } catch (InvalidOptionSelectedException ex) {
//       System.out.println(ex.getMessage());

//       // Catches if the amount is positive
//     } catch (LessThanZeroAmountFoundException ex) {
//       System.out.println(ex.getMessage());

//     } catch(IllegalArgumentException ex) {
//       System.out.println(ex.getMessage());
//     }

//   }

// }
