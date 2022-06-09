import java.sql.*;

public class BaseDAO {
    public static void main(String[] args) throws Exception{
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            System.out.println("Class not found "+ e);
        }
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.1.10/jornt", "jornt", "nO0/Ikl1bd");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *  FROM student");
            stmt.executeUpdate("INSERT INTO student VALUES (6, 'Noekie')");
            System.out.println("stud_id  naam ");

            while (rs.next()) {
                int stud_id = rs.getInt("stud_id");
                String naam = rs.getString("naam");
                System.out.println(stud_id+"   "+naam+"    ");
            }
        } catch(SQLException e) {
            System.out.println("SQL exception occured " + e);
        }
    }
}

