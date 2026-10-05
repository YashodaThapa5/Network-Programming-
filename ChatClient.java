import java.io.*;
import java.net.*;
public class ChatClient {
  public static void main(String[] args){
    String serverAddress = "127.0.0.1";
    int port = 5000;
    try {
      // connect to server
      Socket socket = new Socket(serverAddress, port);
      System.out.println("Connected to server!");
      BufferedReader input = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));
      PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
      // thread for reading message
      Thread readThread = new Thread(() -> {
        try {
          String message;
          while ((message = input.readLine()) != null) {
            System.out.println("S\nerver: " + message);
            if (message.equalsIgnoreCase("exit")) {
              System.out.println("Server disconnected.");
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
            System.out.print("Client: ");
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
        } });
        // start both threads
        readThread.start();
        writeThread.start();
        // wait for both threads to finish
        writeThread.join(); 
        socket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}