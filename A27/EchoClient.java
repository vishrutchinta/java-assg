package A27;
import java.io.*;
import java.net.*;

// Exercise 2 (client): sends a message, prints the echoed reply
public class EchoClient {
    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("localhost", 6000);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String msg;
            do {
                System.out.print("Enter message (exit to quit): ");
                msg = console.readLine();
                out.println(msg);
                System.out.println(in.readLine());
            } while (!msg.equalsIgnoreCase("exit"));
        }
    }
}
