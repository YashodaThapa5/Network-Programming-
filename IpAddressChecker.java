import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

public class IpAddressChecker {

    public static void main(String[] args) {

        String ip = "192.168.1.10";

        try {

            InetAddress address = InetAddress.getByName(ip);

            if (address instanceof Inet4Address && isValidIPv4(ip)) {

                System.out.println("IP Address: " + ip);
                System.out.println("Valid IP : Yes");
                System.out.println("IP Version : IPv4");

            }

            else if (address instanceof Inet6Address && isValidIPv6(ip)) {

                System.out.println("IP Address: " + ip);
                System.out.println("Valid IP : Yes");
                System.out.println("IP Version : IPv6");

            }

            else {

                System.out.println("IP Address: " + ip);
                System.out.println("Valid IP : No");

            }

        }

        catch (Exception e) {

            System.out.println("IP Address: " + ip);
            System.out.println("Valid IP : No");

        }
    }

    public static boolean isValidIPv4(String ip) {

        String[] parts = ip.split("\\.", -1);

        if (parts.length != 4)
            return false;

        for (String part : parts) {

            if (!part.matches("\\d+"))
                return false;

            try {

                int value = Integer.parseInt(part);

                if (value < 0 || value > 255)
                    return false;

            }

            catch (NumberFormatException e) {

                return false;
            }
        }

        return true;
    }

    public static boolean isValidIPv6(String ip) {

        try {

            InetAddress address = InetAddress.getByName(ip);

            return address instanceof Inet6Address;

        }

        catch (Exception e) {

            return false;
        }
    }
}