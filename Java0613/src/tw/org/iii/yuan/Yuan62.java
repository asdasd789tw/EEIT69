package tw.org.iii.yuan;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Yuan62 {

	public static void main(String[] args) {
		try {
			InetAddress ip =InetAddress.getByName("192.168.2.101");
			System.out.println(ip.getHostAddress());
			//getHostAddress傳回String
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
		

	}

}
