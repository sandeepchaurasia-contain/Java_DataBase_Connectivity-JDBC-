package MyDemo;
import java.sql.*;
public class JdbcDemo5 {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
		String user="root";
		String pass="root123";
		
		try {
			Connection con=DriverManager.getConnection(url,user,pass);
			PreparedStatement ps=con.prepareStatement("INSERT INTO student(id, name) VALUES(?, ?)");
			ps.setInt(1, 66);
			ps.setString(2, "mera name joker");
			ps.setString(3,"helllo");
			ps.executeUpdate();
			//ResultSet rs=ps.executeQuery();
			//System.out.println("db connection stablished.....");
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
