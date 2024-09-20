public class Transaction {
  private String referenceID;
  private double amount;
  private Account account;
  private String category;
  private String date;
  private String notes;

  Transaction(String referenceID, double amount, Account account, String category, String date, String notes) {
    this.referenceID = referenceID;
    this.amount = amount;
    this.account = account;
    this.category = category;
    this.date = date;
    this.notes = notes;
    this.amount = amount;
  }

  // to write in the file
  @Override
  public String toString() {
    return referenceID + "\t" + amount + "\t" + account + "\t" + category
        + "\t" + date + "\t" + notes;
  }

}
