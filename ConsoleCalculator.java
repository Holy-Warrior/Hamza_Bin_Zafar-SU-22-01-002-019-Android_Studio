import java.util.Scanner;

public class ConsoleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        System.out.println("Simple Console Calculator");
        System.out.println("-------------------------");

        while (continueCalculating) {
            System.out.print("Enter first number: ");
            // Basic error handling for non-numeric input
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid token
                continue; // Skip to the next iteration
            }
            double num1 = scanner.nextDouble();

            System.out.print("Enter an operator (+, -, *, /): ");
            String operator = scanner.next();

            System.out.print("Enter second number: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid token
                continue; // Skip to the next iteration
            }
            double num2 = scanner.nextDouble();

            double result = 0;
            boolean validOperation = true;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error! Division by zero is not allowed.");
                        validOperation = false;
                    }
                    break;
                default:
                    System.out.println("Error! Invalid operator.");
                    validOperation = false;
                    break;
            }

            if (validOperation) {
                System.out.println("Result: " + num1 + " " + operator + " " + num2 + " = " + result);
            }

            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String continueResponse = scanner.next();
            if (!continueResponse.equalsIgnoreCase("yes")) {
                continueCalculating = false;
            }
            System.out.println(); // Add a blank line for better readability
        }

        System.out.println("Calculator closed. Goodbye!");
        scanner.close();
    }
}
