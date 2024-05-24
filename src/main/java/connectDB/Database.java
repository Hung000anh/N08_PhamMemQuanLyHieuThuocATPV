package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static final String URL = "jdbc:sqlserver://localhost:1433;databasename=QuanLyHieuThuocTay";
    private static final String USER = "sa";
    private static final String PASSWORD = "sa";

    private static Database instance;

    private static Connection connection;

    private Database() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to establish database connection.");
        }
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public static Connection getConnection() {
        try {
        	//if (connection != null) connection.close();
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to establish database connection.");
        }
        return connection;
    }
}
