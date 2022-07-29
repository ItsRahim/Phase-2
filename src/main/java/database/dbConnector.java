package database;

import java.sql.*;
import java.util.Objects;

public class dbConnector {
    private static Connection dbConn;
    private static final String url = "jdbc:mysql://localhost:3306/Mindweaver";

    public static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //connecting to MySQL database
            dbConn = DriverManager.getConnection(url, "root", "password");
            if (dbConn != null) {
                Objects.requireNonNull(dbConn).setAutoCommit(false);
                dbConn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("DB Connection Unsuccessful");
        }
    }

    public static Connection getDbConn() {
        return dbConn;
    }

    public static void closeConn() throws SQLException {
        dbConn.close();
    }
}
