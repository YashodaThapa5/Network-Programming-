import java.net.InetAddress;
public class InetAddressDemo{
    public static void main (String[]args){
        try{
            InetAddress ip = InetAddress.getByName("www.google.com");
            System.out.println("Host Name :" +ip.getHostName());
             System.out.println("IP Address :" +ip.getHostAddress());
             System.out.println("Canonical Host Name :" +ip.getCanonicalHostName());

        } catch(Exception e){
            System.out.println("Error:"+ e.getMessage());
        }
    }
}