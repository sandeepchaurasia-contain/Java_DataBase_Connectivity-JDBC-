package MyDemo;
import java.sql.*;
public class JdbcDemo2 {
	public static void main(String[] args) {
		
		//Class.forName("com.mysql.cj.jdbc.Driver");
			
		String url="jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
		String user="root";
		String pass="root123";
		
		try {
			Connection con=DriverManager.getConnection(url,user,pass);
			System.out.println("db connected");
			
			PreparedStatement ps=con.prepareStatement("SELECT * FROM student");
			ResultSet rs=ps.executeQuery();
			
			System.out.println("ID NAME AGE ");
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getInt("age"));
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
