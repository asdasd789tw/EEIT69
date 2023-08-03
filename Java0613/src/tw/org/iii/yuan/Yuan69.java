package tw.org.iii.yuan;

public class Yuan69 {

	public static void main(String[] args) {
		String passwd= "123456";
		String hashpasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(hashpasswd);
		
		String passwd2 ="123456";
		if(BCrypt.checkpw(passwd2, hashpasswd)) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		System.out.println(hashpasswd.length());

	}

}
