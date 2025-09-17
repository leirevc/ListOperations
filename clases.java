public class Sum {
    private double accumulated = 0;

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b, double c) {
        return a + b + c;
    }

    public void accumulate(double value) {
        accumulated += value;
    }

    public double getAccumulated() {
        return accumulated;
    }
}

public class Sub {
    private double accumulated = 0;

    public double subtract(double a, double b) {
        return a - b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double subtract(double a, double b, double c) {
        return a - b - c;
    }

    public void accumulate(double value) {
        accumulated -= value;
    }

    public double getAccumulated() {
        return accumulated;
    }
}

public class Product {
    public double multiply(double a, double b) {
        return a * b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double multiply(double a, double b, double c) {
        return a * b * c;
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}

public class Division {
    public double divide(double a, double b) {
        return a / b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public double reciprocal(double a) {
        return 1 / a;
    }
}

public class Module {
    public int modulo(int a, int b) {
        return a % b;
    }

    public double absolute(double a) {
        return a >= 0 ? a : -a;
    }
}

public class UnitConverter {
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public double degreesToRadians(double degrees) {
        return degrees * Math.PI / 180;
    }

    public double radiansToDegrees(double radians) {
        return radians * 180 / Math.PI;
    }
}

import java.util.Scanner;

public class CalculatorInterface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Instancias de todas las clases
        Sum sum = new Sum();
        Sub sub = new Sub();
        Product product = new Product();
        Division division = new Division();
        Module module = new Module();
        UnitConverter converter = new UnitConverter();

        while (true) {
            System.out.println("\n=== Calculator Menu ===");
            System.out.println("1. Sum");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulo");
            System.out.println("6. Absolute Value");
            System.out.println("7. Power");
            System.out.println("8. Reciprocal");
            System.out.println("9. Celsius to Fahrenheit");
            System.out.println("10. Fahrenheit to Celsius");
            System.out.println("11. Degrees to Radians");
            System.out.println("12. Radians to Degrees");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter two numbers: ");
                    double a1 = scanner.nextDouble();
                    double b1 = scanner.nextDouble();
                    System.out.println("Result: " + sum.add(a1, b1));
                    break;
                case 2:
                    System.out.print("Enter two numbers: ");
                    double a2 = scanner.nextDouble();
                    double b2 = scanner.nextDouble();
                    System.out.println("Result: " + sub.subtract(a2, b2));
                    break;
                case 3:
                    System.out.print("Enter two numbers: ");
                    double a3 = scanner.nextDouble();
                    double b3 = scanner.nextDouble();
                    System.out.println("Result: " + product.multiply(a3, b3));
                    break;
                case 4:
                    System.out.print("Enter two numbers: ");
                    double a4 = scanner.nextDouble();
                    double b4 = scanner.nextDouble();
                    if (b4 == 0) {
                        System.out.println("Error: Division by zero.");
                    } else {
                        System.out.println("Result: " + division.divide(a4, b4));
                    }
