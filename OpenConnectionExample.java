import java.io.*;
import java.net.*;
public class OpenConnectionExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com"); //URL to fetch
            URLConnection connection = url.openConnection(); //open connection
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print each line of html
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}