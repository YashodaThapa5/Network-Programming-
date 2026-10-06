import java.io.*;
import java.net.*;
public class GetContentExample {
    public static void main(String[] args) {
        try {
          // Define the URL
            URL url = new URL("https://www.example.com"); //Open connection
            //Open Connection
            URLConnection connection = url.openConnection();
            // Get the content of the URL
            Object content = connection.getContent();
            // Cast content to string
            if (content instanceof String) {
                String text = (String) content;
                System.out.println(text); // Print HTML content
            } 
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}