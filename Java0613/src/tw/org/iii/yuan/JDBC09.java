package tw.org.iii.yuan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC09 {

	public static void main(String[] args) {
		String sql = "SELECT * FROM foods";
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iii", prop);
			PreparedStatement pstmtLogin = conn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);// 對conn指向的資料庫下SQL指令
			//TYPE_SCROLL_INSENSITIVE 可將ResultSet任意移動
			//ResultSet.CONCUR_UPDATABLE 可進行直接異動的行為
			ResultSet rs = pstmtLogin.executeQuery();// ResultSet取回查詢結果
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s:%s\n", id, name);
			}
			System.out.println("----------");
			
			if(rs.first()) {
				System.out.println("OK");
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s:%s\n", id, name);
				
				System.out.println("---------");
				rs.absolute(4);
				System.out.printf("%s:%s\n", rs.getString("id"), rs.getString("name"));
				
				System.out.println("---------");
				
//				rs.updateString("name", "田媽媽卓也小屋");
//				rs.updateString("tel", "04-22334567");//目前為止還存在記憶體，還沒寫回資料表
//				rs.updateRow();//存回資料表
//				
//				rs.deleteRow();
				
				rs.moveToInsertRow();//移動到最後一行(輸入表格)
				rs.updateString("name", "Brad大餐館");
				rs.updateString("tel", "04-12358824");
				rs.insertRow();//新增至資料表
				
			}else{
				System.out.println("XX");
			};//將rs從最後一筆移回第一筆
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
