import java.net.*;
public class URIExample {
    public static void main(String[] args) {
        try{
          URI uri = new URI("https", "example.com","/api/data", "id=123","section");
          URL url = uri.toURL();
          System.out.println("Constructed URL: " + url); 
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}