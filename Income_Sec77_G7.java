/**
 * Aysha Hira 1088000
 * Afrah Noor Salim 109111
 * Mehejat Jamal 1090225
 */

public class Income_Sec77_G7 extends Transaction_Sec77_G7 {

  static String[] incomeCategories = { "Part-time job", "Wages", "Other" };

  Income_Sec77_G7(String referenceID, double amount, String accountName, String category, String date, String notes) {
    super(referenceID, amount, accountName, category, date, notes);
    
  }

  public static void viewIncomeCategories() {
    for (int index = 0; index < incomeCategories.length; index++) {
      System.out.println((index + 1) + ". " + incomeCategories[index]);

    }

  }

}
