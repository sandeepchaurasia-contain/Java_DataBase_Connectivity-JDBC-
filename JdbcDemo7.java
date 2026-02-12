package MyDemo;
import java.sql.*;
public class JdbcDemo7 {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
		String user="root";
		String pass="root123";
		
		try(	Connection con=DriverManager.getConnection(url,user,pass);
			PreparedStatement ps=con.prepareStatement("UPDATE student SET age=? WHERE id=?")){

			ps.setInt(1, 70);
			ps.setInt(2, 101);
		 
			int rows=ps.executeUpdate();
			System.out.println(rows+" row updated---->");
		}catch(Exception e) {}
		 
	}
}
