public class Budget {
    public static void main(String[] args) {
        // Print "Hello, World!" to the console
        System.out.println("Hello, Wossxsxqrld!");
    }

    static Object[][] array = {
            {"A", 1.1, 2.2},    // Row 1
            {"B", 3.3, 4.4},    // Row 2
            {"C", 5.5, 6.6},    // Row 3
            {"D", 7.7, 8.8},    // Row 4
            {"E", 9.9, 10.1},   // Row 5
            {"F", 11.2, 12.3},  // Row 6
            {"G", 13.4, 14.5},  // Row 7
            {"H", 15.6, 16.7},  // Row 8
            {"I", 17.8, 18.9},  // Row 9
            {"J", 19.0, 20.1}   // Row 10
        };

    public static void viewAllCategoriesAndBudget() {
        // Print the 2D array to check the initialization
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i][0] + " "); // Print String (first column)
            for (int j = 1; j < array[i].length; j++) {
                System.out.print(array[i][j] + " "); // Print double (second and third columns)
            }
            System.out.println();
        }
    }

    public static void viewAllCategories() {
        // Print the 2D array to check the initialization
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i][0] + "\n"); // Print String (first column)
        }
    }

    public static void viewExpenseCategories() {
        
    }


}
