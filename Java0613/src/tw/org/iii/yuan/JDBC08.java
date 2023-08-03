package tw.org.iii.yuan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class JDBC08 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Account = ");
		String account = scanner.next();
		System.out.print("Password = ");
		String passwd = scanner.next();
		
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iii", prop);
			String sqlLogin = "SELECT * FROM member WHERE account =?";
			PreparedStatement pstmtLogin = conn.prepareStatement(sqlLogin);//對conn指向的資料庫下SQL指令
			pstmtLogin.setString(1, account);//setString定義SQL語法內的"?"
			ResultSet rs = pstmtLogin.executeQuery();//ResultSet取回查詢結果
			if (rs.next()) {
				String haspasswd =rs.getString("password");
				if(BCrypt.checkpw(passwd, haspasswd)) {
					System.out.println("Welcome, "+ rs.getString("cname"));
				}else {
					System.out.println("ERR2");
				}
			}else {
				System.out.println("ERR1");
			}
		} catch (Exception e) {
			System.out.println(e);
		}


	}//帳號密碼登入

}
