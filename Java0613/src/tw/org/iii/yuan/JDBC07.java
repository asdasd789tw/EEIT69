package tw.org.iii.yuan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC07 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Account = ");
		String account = scanner.next();
		System.out.print("Password = ");
		String passwd = scanner.next();
		System.out.print("Name = ");
		String name = scanner.next();

		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", prop);
			//localhost預設port號是3066,http預設port號是80,https預設port號是443
			String sqlDup = "SELECT * FROM member WHERE account =?";
			PreparedStatement pstmtDup = conn.prepareStatement(sqlDup);//對conn指向的資料庫下SQL指令
			pstmtDup.setString(1, account);//setString定義SQL語法內的"?"
			ResultSet rs = pstmtDup.executeQuery();//ResultSet取回查詢結果
			if (!rs.next()) {
				String sql = "INSERT INTO member (account,password,cname) VALUES (?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, account);
				pstmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
				pstmt.setString(3, name);

				int n = pstmt.executeUpdate();
				if (n == 0) {
					System.out.println("ERR");
				} else {
					System.out.println("OK");
				}
			}else {
				System.out.println("Duplicate");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}//新增資料庫並加密密碼且檢查有無重複

}
