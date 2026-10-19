package A27;
import java.io.*;
import java.net.*;

// Exercise 1 (client)
public class ChatClient {
    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("localhost", 5001);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Connected to server. Type 'bye' to end.");
            while (true) {
                System.out.print("Client: ");
                String msg = console.readLine();
                out.println(msg);
                if (msg.equalsIgnoreCase("bye")) break;
                String reply;
try { reply = in.readLine(); } catch (SocketException e) { reply = null; }
                if (reply == null || reply.equalsIgnoreCase("bye")) break;
                System.out.println("Server: " + reply);
            }
            System.out.println("Chat ended.");
        }
    }
}
