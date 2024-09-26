import Interfacess.AddAndSubtract;

public class Account implements AddAndSubtract {
  private double balance = 0;
  public String name;

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
 