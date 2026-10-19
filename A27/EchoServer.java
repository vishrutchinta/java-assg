package A27;
import java.io.*;
import java.net.*;

// Exercise 2 (server): returns every message back to the client
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(6000)) {
            System.out.println("Echo server listening on port 6000...");
            try (Socket s = server.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                 PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("Received: " + msg);
                    out.println("Echo: " + msg);
                    if (msg.equalsIgnoreCase("exit")) break;
                }
            }
            System.out.println("Server closed.");
        }
    }
}
