package MyDemo;
import java.sql.*;
public class JdbcDemo{
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

	        //String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String pass = "root123";

	        Connection con = DriverManager.getConnection(url, user, pass);
	        System.out.println(" DB Connected");

	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM student");

	        while (rs.next()) {
	        	System.out.println(rs.getInt("id") + " " +rs.getString("name") + " " +rs.getInt("age"));
	        }

	        con.close();
	     } catch (Exception e) {
	            e.printStackTrace();
	     }
	    
	}

}
