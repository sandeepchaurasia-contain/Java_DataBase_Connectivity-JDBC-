package MyDemo;
import java.sql.*;

public class JdbcDemo11 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "root123";

        String sql = "INSERT INTO student(name, age) VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = con.prepareStatement(sql)) {

            for (int i = 1; i <= 5; i++) {
                ps.setString(1, "User" + i);
                ps.setInt(2, 20 + i);
                ps.addBatch();   // batch me add
            }

            int[] result = ps.executeBatch(); // execute all
            System.out.println("Inserted rows: " + result.length);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
