package MyDemo;
import java.sql.*;
public class JdbcDemo1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
			String user="root";
			String pass="root123";
			
			Connection con=DriverManager.getConnection(url,user,pass);
			System.out.println("DB connected..........");
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
