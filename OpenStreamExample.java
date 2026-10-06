import java.io.*;
import java.net.*;
public class OpenStreamExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com"); //URL to fetch
            InputStream inputStream = url.openStream(); //open stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print webpage content
            }
            reader.close();
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

