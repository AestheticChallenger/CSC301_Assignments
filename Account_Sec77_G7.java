
/**
 * Aysha Hira 1088000
 * Afrah Noor Salim 109111
 * Mehejat Jamal 1090225
 */

import Interfacess.AddAndSubtract_Sec77_G7;

public class Account_Sec77_G7 implements AddAndSubtract_Sec77_G7 {
  private double balance;
  public String name;

  Account_Sec77_G7(String name) {
    this.name = name;
    this.balance = 0;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addAmount(double amount) {
    this.balance = getBalance() + amount;
  }

  public void subtractAmount(double amount) {
    this.balance = getBalance() - amount;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

}
 