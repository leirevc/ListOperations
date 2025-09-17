import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ListOperations {

    // Predefined list of numbers used for all operations
    static ArrayList<Integer> numberList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize list with predefined values
        initializeList();

        int choice;

        // Menu loop continues until user chooses to exit (option 5)
        while (true) {
            System.out.println("\n=== Data Structure Operations Menu ===");
            System.out.println("1. Show Maximum Value");
            System.out.println("2. Count Occurrences");
            System.out.println("3. Filter Greater Than a Threshold");
            System.out.println("4. Group Even and Odd Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showMaxValue();
                    break;
                case 2:
                    System.out.print("Enter a number to count: ");
                    int numToCount = scanner.nextInt();
                    countOccurrences(numToCount);
                    break;
                case 3:
                    System.out.print("Enter threshold value: ");
                    int threshold = scanner.nextInt();
                    ArrayList<Integer> filtered = filterGreaterThan(numberList, threshold);
                    System.out.println("Values greater than " + threshold + ": " + filtered);
                    break;
                case 4:
                    Map<String, ArrayList<Integer>> grouped = groupEvenOdd(numberList);
                    System.out.println("Even Numbers: " + grouped.get("even"));
                    System.out.println("Odd Numbers: " + grouped.get("odd"));
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number from 1 to 5.");
            }
        }
    }

    // Initializes the predefined list
    public static void initializeList() {
        int[] nums = {3, 6, 9, 1, 7, 2, 4, 8, 5};
        for (int num : nums) {
            numberList.add(num);
        }
    }

    // 1. Show the maximum value in the list
    public static void showMaxValue() {
        if (numberList.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        int max = numberList.get(0);
        for (int num : numberList) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Maximum value in the list: " + max);
    }

    // 2. Count how many times a number appears in the list
    public static void countOccurrences(int number) {
        int count = 0;
        for (int num : numberList) {
            if (num == number) {
                count++;
            }
        }
        System.out.println("Number " + number + " occurs " + count + " time(s) in the list.");
    }

    // 3. Return a list of numbers greater than a given threshold
    public static ArrayList<Integer> filterGreaterThan(ArrayList<Integer> list, int threshold) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : list) {
            if (num > threshold) {
                result.add(num);
            }
        }
        return result;
    }

    // 4. Group numbers into even and odd using a map
    public static Map<String, ArrayList<Integer>> groupEvenOdd(ArrayList<Integer> list) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for (int num : list) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }

        Map<String, ArrayList<Integer>> result = new HashMap<>();
        result.put("even", even);
        result.put("odd", odd);
        return result;
    }
}