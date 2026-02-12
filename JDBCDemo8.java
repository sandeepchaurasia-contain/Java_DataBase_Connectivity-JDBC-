package MyDemo;

import java.sql.*;

public class JDBCDemo8 {

    static String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
    static String user = "root";
    static String pass = "root123";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            // ================= INSERT =================
            System.out.println("----- INSERT OPERATION -----");

            PreparedStatement insertPs = con.prepareStatement(
                    "INSERT INTO student(name, age) VALUES (?, ?)");

            insertPs.setString(1, "Rohit");
            insertPs.setInt(2, 23);

            int insertRows = insertPs.executeUpdate();
            System.out.println(insertRows + " row inserted\n");

            displayData(con);

            // ================= UPDATE =================
            System.out.println("\n----- UPDATE OPERATION -----");

            PreparedStatement updatePs = con.prepareStatement(
                    "UPDATE student SET age=? WHERE name=?");

            updatePs.setInt(1, 30);
            updatePs.setString(2, "Rohit");

            int updateRows = updatePs.executeUpdate();
            System.out.println(updateRows + " row updated\n");

            displayData(con);

            // ================= DELETE =================
            System.out.println("\n----- DELETE OPERATION -----");

            PreparedStatement deletePs = con.prepareStatement(
                    "DELETE FROM student WHERE name=?");

            deletePs.setString(1, "Rohit");

            int deleteRows = deletePs.executeUpdate();
            System.out.println(deleteRows + " row deleted\n");

            displayData(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to display table data
    public static void displayData(Connection con) throws Exception {

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");

        System.out.println("Current Data in student table:");
        System.out.println("--------------------------------");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getInt("age"));
        }
    }
}
