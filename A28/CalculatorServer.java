package A28;
import java.rmi.registry.*;

public class CalculatorServer {
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.createRegistry(1099);   // starts the RMI registry
        reg.rebind("CalculatorService", new CalculatorImpl());
        System.out.println("Calculator RMI server is ready.");
    }
}
