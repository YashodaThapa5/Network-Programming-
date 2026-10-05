
import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        int port = 5000;
        try {
            // Create server socket
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started...");
            System.out.println("Waiting for client connection...");

            // Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Input stream: Read messages from client
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Output stream: Send messages to client
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // thread for reading message
            Thread readThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = input.readLine()) != null) {
                        System.out.println("Client: " + message);
                        if (message.equalsIgnoreCase("exit")) {
                            System.out.println("Client disconnected.");
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            });

            // thread for writing message
            Thread writeThread = new Thread(() -> {
                try {
                    BufferedReader keyboard = new BufferedReader(
                            new InputStreamReader(System.in));
                    String message;
                    while (true) {
                        message = keyboard.readLine();
                        if (message == null) {
                            break;
                        }
                        output.println(message);
                        if (message.equalsIgnoreCase("exit"))
                            break;
                    }
                } catch (IOException e) {
                    System.out.println("Error sending message.");
                }
            });

            // start both threads
            readThread.start();
            writeThread.start();

            // wait for both writing threads to finish
            writeThread.join();
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}