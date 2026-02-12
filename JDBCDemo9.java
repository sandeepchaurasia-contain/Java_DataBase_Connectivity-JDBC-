package MyDemo;
import java.sql.*;
import java.util.Scanner;

public class JDBCDemo9 {
	public static void main(String[] args) {
		 String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
	     String user = "root";
	     String pass = "root123";
	     
	     Scanner sc=new Scanner(System.in);
	     System.out.println("Enter name: ");
	     String name=sc.nextLine();
	     
	     String sql="SELECT * FROM student WHERE name= ?";
	     
	     
	     try (Connection con = DriverManager.getConnection(url, user, pass);
	         PreparedStatement ps = con.prepareStatement(sql)) {
	    	 	 ps.setString(1, name);
	    	 	 ResultSet rs=ps.executeQuery();
	    	 	 
	    	 	 while(rs.next()) {
	    	 		 
	    	 		 System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getInt("age"));
	    	 	 }
	    	 	
	     }catch(Exception e) {}
	}
}
