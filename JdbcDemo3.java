package MyDemo;
import java.sql.*;
public class JdbcDemo3 {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
		String user="root";
		String pass="root123";
		
		String sql="INSERT INTO student(name, age) VALUES(?, ?)";
	
		try {
			Connection con =DriverManager.getConnection(url,user,pass);
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, "Sandeep");
			ps.setInt(2, 25);
			
			int rows=ps.executeUpdate();
			System.out.println(rows+" row inserted");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
