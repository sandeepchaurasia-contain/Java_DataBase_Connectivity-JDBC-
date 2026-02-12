package MyDemo;
import java.sql.*;
public class JbbcDemo6 {
	public static void main(String[] args) {
		 String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
	     String user = "root";
	     String pass = "root123";
	     
	     Connection con=null;
	     PreparedStatement insertPs=null;
	     PreparedStatement selectPs=null;
	     ResultSet rs=null;
	     
	     try {
	    	 	//connection make
	    	 	con=DriverManager.getConnection(url,user,pass);
	    	 	System.out.println(" connection stablished...");
	    	 
	    	 	//Prepare INSERT query
	    	 	String insertQuery="INSERT INTO student(id, name)VALUES(?, ?)";
	    	 	insertPs=con.prepareStatement(insertQuery);
	    	 	
	    	 	
	    	 	//set values for INSERT
	    	 	
	    	 	insertPs.setInt(1, 101);
	    	 	insertPs.setString(2,"sandeep ");
	    	 	
	    	 	//execute INSERT query
	    	 	
	    	 	int inserted=insertPs.executeUpdate();
	    	 	System.out.println(inserted+"row(s) inserted");
	    	 	
	    	 	//prepare SELECT query to read data
	    	 	String selectQuery="SELECT * FROM student";
	    	 	selectPs=con.prepareStatement(selectQuery);
	    	 	
	    	 	//execute SELECT query
	    	 	rs=selectPs.executeQuery();
	    	 	System.out.println("reading data from the stdudent table");
	    	 	
	    	 	//proceess result set
	    	 	while(rs.next()) {
	    	 		int id=rs.getInt("id");
	    	 		String name=rs.getString("name");
	    	 		System.out.println("ID: "+id+",Name: "+name);
	    	 	}
	     }catch(Exception e) {
	    	 	e.printStackTrace();
	     }finally {
	    	 //close resourses
	    	 	try {
	    	 		if(rs!=null)rs.close();
	    	 		if(insertPs!=null)insertPs.close();
	    	 		if(selectPs!=null)selectPs.close();
	    	 		if(con!=null)con.close();
	    	 		System.out.println("closed resourse..");
	    	 	}catch(Exception e) {}
	     }
	}
}
