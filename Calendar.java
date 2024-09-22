import java.util.Date;

public class Calendar {
  private int year;
  private int month;
  private int day;

  public Calendar(int year, int month, int day) {
    if (checkIfValidDate(day, month, year)) {
      setYear(year);
      setMonth(month);
      setYear(year);
    }

  }

  // Getter for year
  public int getYear() {
    return year;
  }

  // Setter for year
  public void setYear(int year) {
    this.year = year;
  }

  // Getter for month
  public int getMonth() {
    return month;
  }

  // Setter for month
  public void setMonth(int month) {
    if (month < 1 || month > 12)
      throw new IllegalArgumentException("Month must be between 1 and 12");
    this.month = month;
  }

  // Getter for day
  public int getDay() {
    return day;
  }

  public boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
  }

  public boolean checkIfValidDate(int day, int month, int year) {
    if (month < 1 || month > 12) {
      return false;
    }
    return day >= 1 && day <= getTheLastDaysnMonth(month, year);
  }

  private int getTheLastDaysnMonth(int month, int year) {
    switch (month) {
      case 1: // January
      case 3: // March
      case 5: // May
      case 7: // July
      case 8: // August
      case 10: // October
      case 12: // December
        return 31;

      case 4: // April
      case 6: // June
      case 9: // September
      case 11: // November
        return 30;

      case 2: // February
        return (isLeapYear(year)) ? 29 : 28;

      default:
        throw new IllegalArgumentException("The Month should be between 1 and 12.");
    }
  }

  public Calendar[] getThisWeek(Calendar date) {
    Calendar[] weekDates = new Calendar[7];

    int currentYear = date.getYear();
    int currentMonth = date.getMonth();
    int currentDay = date.getDay();

    // Start with the current date
    // The current date is out as the last element in the array (7th day)
    weekDates[6] = new Calendar(currentYear, currentMonth, currentDay); // Last day of the week

    // The loop finds the remaing days of the week by atrting from the previous day (6thday)
    for (int i = 5; i >= 0; i--) {
      currentDay--; // Move to the previous day

      // Adjust the date
      if (currentDay < 1) {
        currentMonth--; // Move to the previous month

        if (currentMonth < 1) {
          currentMonth = 12; // Wrap to December
          currentYear--; // Move to the previous year
        }
        currentDay = getTheLastDaysnMonth(currentMonth, currentYear); // Get days in the new month
      }

      // February has 28 / 29 days depending if its leap year
      else if (currentDay < 1 && currentMonth == 3) {
        if (isLeapYear(currentYear)) {
          currentDay = 29;
        }

        else {
          currentDay = 28;
        }
        currentMonth--;
      }

      // Create a new Date object for the current day
      weekDates[i] = new Calendar(currentYear, currentMonth, currentDay);
    }

    return weekDates;
  }

  /**
   * NEED TO MAKE A COMPARABLE HERE TO SORT THE ARRAYLIST????
   */

}
