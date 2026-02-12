package MyDemo;
import java.sql.*;

public class JdbcDemo10 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "root123";

        Connection con = null;

        try {
            con = DriverManager.getConnection(url, user, pass);
            con.setAutoCommit(false); // start transaction

            PreparedStatement p1 =
                con.prepareStatement("UPDATE acc SET bal = bal - 100 WHERE id = 1");
            p1.executeUpdate();

            PreparedStatement p2 =
                con.prepareStatement("UPDATE acc SET bal = bal + 100 WHERE id = 2");
            p2.executeUpdate();

            con.commit(); // success
            System.out.println("Transaction success");

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback(); // ✅ same connection
                    System.out.println("Transaction rolled back");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {}
        }
    }
}
