package MyDemo;
import java.sql.*;
public class JdbcDemo4 {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
		String user="root";
		String pass="root123";
		
		String sql="UPDATE student SET age= ? WHERE id=?";
	
		try {
			Connection con =DriverManager.getConnection(url,user,pass);
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 26);
			ps.setInt(2, 1);
			
			int rows=ps.executeUpdate();
			System.out.println(rows+" row updated...");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
