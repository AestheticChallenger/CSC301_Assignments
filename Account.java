public class Account implements AddAndSubtract{
  private double balance;

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
