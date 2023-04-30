import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalcServer {

    public static void main(String[] args) {
        try {
            // Create an instance of the remote object
            CalcImpl calc = new CalcImpl();

            // Create the RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object to the registry with the name "Calculator"
            registry.rebind("Calculator", calc);

            // Clear screen
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Calculator Server ready...");

        } catch (Exception e) {
            System.err.println("Calculator Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}