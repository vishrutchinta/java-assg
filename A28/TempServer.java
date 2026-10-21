package A28;
import java.rmi.registry.*;

public class TempServer {
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.rebind("TempService", new TempConverterImpl());
        System.out.println("Temperature RMI server is ready.");
    }
}
