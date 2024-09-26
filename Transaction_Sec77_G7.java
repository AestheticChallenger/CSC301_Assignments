/**
 * Aysha Hira 1088000
 * Afrah Noor Salim 109111
 * Mehejat Jamal 1090225
 */

public class Transaction_Sec77_G7 {
  private String referenceID;
  private double amount;
  private String accountName;
  private String category;
  private String date;
  private String notes;

  Transaction_Sec77_G7(String referenceID, double amount, String accountName, String category, String date, String notes) {
    this.referenceID = referenceID;
    this.amount = amount;
    this.accountName = accountName;
    this.category = category;
    this.date = date;
    this.notes = notes;
  }

  // to write in the file
  @Override
  public String toString() {
    return referenceID + "\t" + amount + "\t" + accountName + "\t" + category
        + "\t" + date + "\t" + notes;
  }

  public String getReferenceID() {
    return referenceID;
  }

  public void setReferenceID(String referenceID) {
    this.referenceID = referenceID;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

}
