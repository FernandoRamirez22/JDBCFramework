import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./res/HR";

        //  Database credentials, will use this every time I code connect a database using JDBC
        final String USER = "";
        final String PASS = "";
        Connection conn = null;         //conn is an instance of an object
        Statement stmt = null;         //

        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);         //Don't publish into GitHub without editing database readability (Passwords)

            //STEP 3: Execute a query
            stmt = conn.createStatement();

            String sql = "SELECT * FROM JOBS";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            // STEP 4: Clean-up environment and close it.
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
