package tw.org.iii.yuan;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Yuan66 {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999);
			System.out.println("Wait....");
			Socket socket = server.accept();
			
			String urip = socket.getInetAddress().getHostAddress();
			
			FileOutputStream fout = new FileOutputStream(String.format("dir1/%s.jpg", urip));

			InputStream in = socket.getInputStream();
			BufferedInputStream bin = new BufferedInputStream(in);
			byte[] buf = new byte[4 * 1024 * 1024];
			int len;
			while ((len = bin.read(buf)) != -1) {
				fout.write(buf,0,len);
			}
			bin.close();
//			int c;
//			while ((c = in.read()) != -1) {
//				System.out.print((char)c);
//			}
			fout.flush();
			fout.close();
			server.close();

			System.out.println("\nServer OK");
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
