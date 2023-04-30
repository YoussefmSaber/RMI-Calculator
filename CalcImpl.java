import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcImpl extends UnicastRemoteObject implements CalcInterface {

    public CalcImpl() throws RemoteException {
        super();
    }

    
    public double add(double num1, double num2) throws RemoteException {
        return num1 + num2;
    }

   
    public double subtract(double num1, double num2) throws RemoteException {
        return num1 - num2;
    }

    
    public double multiply(double num1, double num2) throws RemoteException {
        return num1 * num2;
    }

    
    public double divide(double num1, double num2) throws RemoteException {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return num1 / num2;
    }
}