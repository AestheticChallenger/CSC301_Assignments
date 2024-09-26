
/**
 * Aysha Hira 1088000
 * Afrah Noor Salim 109111
 * Mehejat Jamal 1090225
 */

import java.time.LocalDate;
import Interfacess.AddAndSubtract_Sec77_G7;

public class FinancialGoals_Sec77_G7 implements AddAndSubtract_Sec77_G7 {
  LocalDate endDate;
  boolean isSet = false;
  double targetAmount = 0;
  double savedAmount = 0;

  FinancialGoals_Sec77_G7(int year, int month, int day, double targetAmount) {
    this.endDate = LocalDate.of(year, month, day); // creats an end date
    this.isSet = true; // shows that financia goal is complete
    this.targetAmount = targetAmount; // sets the financial goal
  }

  public FinancialGoals_Sec77_G7() {
    // TODO Auto-generated constructor stub
  }

  // Updates the financial goals
  public void update(double amount) {
    this.savedAmount = amount;
  }

  // Gets the Progress
  public String getProgress() {
    // Rounds the remaining decimals after the 2 decimal
    // Shows how much of the financial goal the user has achieved
    System.out.println("You have achieved "
        + Math.round((savedAmount / targetAmount) * 100) / 100 + "% of the " + targetAmount);

    // Shows how much the
    return "The remaining amount to complete this financial goal is: AED" + (targetAmount - savedAmount);
  }

  // Adds the amount from the saved amount
  public void addAmount(double amount) {
    this.savedAmount += amount;
  }

  // Subtracts the amount from the saved amount
  public void subtractAmount(double amount) {
    this.savedAmount -= amount;
  }

}
