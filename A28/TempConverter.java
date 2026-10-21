package A28;
import java.rmi.*;

// Exercise 2: remote interface for temperature conversion
public interface TempConverter extends Remote {
    double celsiusToFahrenheit(double c) throws RemoteException;
    double fahrenheitToCelsius(double f) throws RemoteException;
}
