package A28;
import java.rmi.registry.*;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("localhost", 1099);
        Calculator calc = (Calculator) reg.lookup("CalculatorService");   // 'calc' is the stub
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        double a = sc.nextDouble(), b = sc.nextDouble();
        System.out.println("Sum        = " + calc.add(a, b));
        System.out.println("Difference = " + calc.subtract(a, b));
        System.out.println("Product    = " + calc.multiply(a, b));
        System.out.println("Quotient   = " + calc.divide(a, b));
    }
}
