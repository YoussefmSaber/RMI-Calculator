import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class CalcClient {

    public static void main(String[] args) {
        try {
            // Lookup the remote object by name
            CalcInterface calc = (CalcInterface) Naming.lookup("rmi://localhost/Calculator");

            // Clear screen
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Calculator Client ready...");

            Thread.sleep(1200);

            // Create an instance of the remote object
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            do {
                // Clear screen
                System.out.print("\033[H\033[2J");
                System.out.flush();
                // Display menu
                System.out.println("==== Welcome to calculator using RMI ====");
                Thread.sleep(1200);

                System.out.print("Enter the operation you like: ");
                String input = reader.readLine();
                String[] tokens = input.split(" ");

                // Parse input and perform calculation
                if (tokens.length == 3) {
                    // Parse the numbers
                    double num1 = Double.parseDouble(tokens[0]);
                    String operator = tokens[1];
                    double num2 = Double.parseDouble(tokens[2]);
                    // Perform the calculation
                    double result = 0;
                    switch (operator) {
                        case "+":
                            result = calc.add(num1, num2);
                            System.out.println("Result: " + result);
                            break;
                        case "-":
                            result = calc.subtract(num1, num2);
                            System.out.println("Result: " + result);
                            break;
                        case "*":
                            result = calc.multiply(num1, num2);
                            System.out.println("Result: " + result);
                            break;
                        case "/":
                            if (num2 == 0)
                                System.out.println("Division by zero");
                            else {
                                result = calc.divide(num1, num2);
                                System.out.println("Result: " + result);
                            }
                            break;
                        default:
                            System.out.println("Invalid operator: " + operator);
                            System.exit(1);
                    }

                    System.out.print("Do you want to preform another operation(yes/no): ");
                    String answer = reader.readLine();
                    if (answer.equals("no")
                            || answer.equals("No")
                            || answer.equals("NO")
                            || answer.equals("n")
                            || answer.equals("N"))
                        break;
                } else
                    System.out.println("Invalid input format.");
            } while (true);

        } catch (Exception e) {
            // Display the error message
            System.err.println("Calculator Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}