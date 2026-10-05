import java.net.InetAddress;
import java.net.UnknownHostException;
public class SpamCheckIp {
  public static boolean isSpam (String ipAddress) {
    String blacklistDomain = "sbl.spamhaus.org";
// Reverse the IP address properly
    String[] parts = ipAddress.split("\\.");
    String reversedipAddress = parts[3] +"." + parts[2] + "." + parts[1] + "." + parts[0];
    String query = reversedipAddress +"." + blacklistDomain;
    try {
      // Perform a DNS lookup
      InetAddress address = InetAddress.getByName(query);
      // If the lookup succeeds and returns "127.0.0.2", it's blacklisted
      return address.getHostAddress().equals("127.0.0.2");
      } catch (UnknownHostException ex) {
  // DNS lookup failed, assume the IP is not blacklisted
      return false;
      }
    }
  public static void main(String[] args) {
  String ipAddress = "192.0.2.1";
  boolean isSpam = isSpam(ipAddress);
  System.out.println("Is spam: " + isSpam);
}
}