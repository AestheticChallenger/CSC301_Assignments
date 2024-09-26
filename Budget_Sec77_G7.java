import java.util.*;

public class Budget_Sec77_G7 extends Goal_Sec77_G7 {
    Scanner input = new Scanner(System.in);

    static Object[][] array = { { "FOOD", 0.0, 0.0 }, { "GROCERIES", 0.0, 0.0 }, { "UTILITIES", 0.0, 0.0 },
            { "RENT", 0.0, 0.0 }, { "TRANSPORT", 0.0, 0.0 }, { "MISCELLANEOUS", 0.0, 0.0 } };

    public void budgetmenu() {
        System.out.println("1. Set budget for category " + "\n" + "2. Show remaining amount" + "\n" + "3.Show Progress"
                + "\n" + "4. Set Budget For All");
        int choice = input.nextInt();
        Budget_Sec77_G7 Budget = new Budget_Sec77_G7();
        try {
            if (choice == 1 || choice == 2 || choice == 3) {
                System.out.println(
                        Arrays.deepToString(array) + "\n" + "Choose the category(please type in all capital");
                String categoryinput = input.next();
                /*
                 * menu for all services in budget if
                 * options 1,2,3 then print array if 4 then do
                 * not because it will iterate thru all and set budget for all
                 */

                if (choice == 1) {
                    System.out.println("enter amount to set as budget");
                    double budgetset = input.nextDouble();
                    Budget.setbudget(categoryinput, budgetset);
                    // set budget for 1 category
                }
                if (choice == 2) {
                    Budget.remainingamount(categoryinput);
                    // show remaining amount left to spend
                }
                if (choice == 3) {
                    Budget.getProgress(categoryinput);
                    // shoe percentage of how much spent
                }
            }

            else if (choice == 4) {
                Budget.setBudgetForAllCategories();
                // set budget for all
            }

            else {
                System.out.println("Invalid choice, please select from the menu options.");
                // invalid input
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(
                    "Error: Attempted to access an invalid category or array element. Please check your input.");
            // cathch exception
        }
    }

    public void setbudget(String nameOfCategory, double amount) {

        for (int i = 0; i < array.length; i++) {
            if (array[i][0].equals(nameOfCategory)) {
                array[i][1] = amount;
                array[i][2] = amount;
                System.out.println("Budget for " + nameOfCategory + " is : " + array[i][1]);
                this.totalAmount = amount;
                this.currentAmount = amount;
                // finds the gives category and sets its budget
            }
        }
    }

    public void setBudgetForAllCategories() {
        System.out.println("Please set the budget for each category:");

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter budget for " + array[i][0] + ": ");
            double budgetAmount = input.nextDouble();
            array[i][1] = budgetAmount; // Set the total budget
            array[i][2] = budgetAmount; // Set the remaining budget

            System.out.println("Budget for " + array[i][0] + " set to: " + array[i][1]);
            // sets budget for all one by one
        }

        System.out.println("All categories have been updated with the specified budgets.");
    }

    public static void subtractfrombudget(String nameOfCategory, double amount) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][0].equals(nameOfCategory)) {

                // The i refers to the row, 2 represents the third column, i.e remainiing amount
                // is in the third column
                double remainingAmount = (double) array[i][2];
                remainingAmount = remainingAmount - amount;
                array[i][2] = remainingAmount;
                System.out.println("Remaining Budget for " + nameOfCategory + "is :" + array[i][2]);
                // calculates amount left after a transaction
            }
        }

    }

    public static void remainingamount(String nameOfCategory) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][0].equals(nameOfCategory)) {
                double remainingAmount = (double) array[i][2];

                System.out.println("Remaining Budget for " + nameOfCategory + "is :" + array[i][2]);
                // shoes the remaining amount in the 3rd column
            }
        }

    }

    public void resetbudget(String nameOfCategory, double amount) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][0].equals(nameOfCategory)) {
                array[i][1] = 0;
                System.out.println("Budget for " + nameOfCategory + "is :" + array[i][1]);
                // resets budget to 0
            }

        }
    }

    public String getProgress(String nameOfCategory) {
        int index = 0;
        switch (nameOfCategory.charAt(0)) {
            case 'F': {
                index = 0;
                break;

            }

            case 'G': {
                index = 1;
                break;

            }
            case 'U': {
                index = 2;
                break;
            }
            case 'R': {
                index = 3;
                break;

            }
            case 'T': {
                index = 4;
                break;

            }
            case 'M': {
                index = 5;
                break;

            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + nameOfCategory);
        }

        double BudgetSet = (double) array[index][1];
        double RemainingAmount = (double) array[index][2];
        double percentageSpent = Math.round(((BudgetSet - RemainingAmount) / BudgetSet) * 100.0) / 100.0;
        System.out.println("You have spent " + percentageSpent + "% of your budget for this category.");
        return getProgress();
        // gets the percentage of budget set by iterating thru array and finding the
        // category
    }

    @Override
    public void update(double amount) {
        this.currentAmount = amount;
    }

    // updates THE CURRENT anmount by overriding it from abstract class
    @Override
    public String getProgress() {
        // TODO Auto-generated method stub
        return "The remaining budget for this category is: AED " + currentAmount;
    }
    // returns progress

}
