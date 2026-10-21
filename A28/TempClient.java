package A28;
import java.rmi.registry.*;
import java.util.Scanner;

public class TempClient {
    public static void main(String[] args) throws Exception {
        TempConverter t = (TempConverter) LocateRegistry.getRegistry("localhost", 1099).lookup("TempService");
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Celsius to Fahrenheit\n2. Fahrenheit to Celsius");
        System.out.print("Choice: ");
        int ch = sc.nextInt();
        System.out.print("Enter temperature: ");
        double v = sc.nextDouble();
        if (ch == 1) System.out.printf("%.2f C = %.2f F%n", v, t.celsiusToFahrenheit(v));
        else         System.out.printf("%.2f F = %.2f C%n", v, t.fahrenheitToCelsius(v));
    }
}
