/**
 * Aysha Hira 1088000
 * Afrah Noor Salim 109111
 * Mehejat Jamal 1090225
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FinancialReport {
  public static void generateFinancialReport() {
    DateTimeFormatter monthFormat = DateTimeFormatter.ofPattern("MMMM yyyy");

    // filter and display transactions within the specified date range
    for (Transaction_Sec77_G7 transaction : BudgetMaster_Sec77_G7.transactionList) {
      LocalDate transactionDate = transaction.getDate();
      if (!transaction.getDate().isBefore(startDate) && !transaction.getDate().isAfter(endDate)) {
        System.out.print("Account: " + transaction.getAccount()
            + "\nAmount: AED " + transaction.getAmount()
            + "\nType: " + transaction.getCategory()
            + "\nDate: " + transaction.getDate().format(DateTimeFormatter.ofPattern("dd/mm/yyyy"))
            + "\nNotes: " + transaction.getNotes()
            + "\n-------------------------------");
      }
    }
    // for the current date
    LocalDate currentDate = LocalDate.now();

    // Array to hold the 7 week dates
    LocalDate[] weekDates = new LocalDate[7];

    // filling the array with the current day and the previous six days
    for (int i = 6; i >= 0; i--) {
      weekDates[i] = currentDate.minusDays(i);
      System.out.println(weekDates[i]);
    }

    // first day of the current month
    LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
    // Total days in the current month
    int daysInMonth = currentDate.lengthOfMonth();

    // Array to hold the month dates
    LocalDate[] monthDates = new LocalDate[daysInMonth];

    for (int i = 0; i < daysInMonth; i++) {
      monthDates[i] = firstDayOfMonth.plusDays(i);
    }
  }

}
