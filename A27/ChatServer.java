package A27;
import java.io.*;
import java.net.*;

// Exercise 1 (server): simple two-way chat. Start this first, then ChatClient.
public class ChatServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(5001)) {
            System.out.println("Chat server waiting on port 5001...");
            try (Socket s = server.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                 PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                 BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Client connected. Type 'bye' to end.");
                String msg;
                while (true) {
                    try { msg = in.readLine(); } catch (SocketException e) { msg = null; }
                    if (msg == null || msg.equalsIgnoreCase("bye")) break;
                    System.out.println("Client: " + msg);
                    System.out.print("Server: ");
                    String reply = console.readLine();
                    out.println(reply);
                    if (reply.equalsIgnoreCase("bye")) break;
                }
                System.out.println("Chat ended.");
            }
        }
    }
}
