package user_app;
import java.sql.*;
public class DatabaseSingleton {
    private static DatabaseSingleton instance;
    private Connection connection;
    private Statement statement;

    private DatabaseSingleton() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/"+Settings.DATABASE_NAME, 
            Settings.USER, Settings.PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DatabaseSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseSingleton();
        }
        return instance;
    }

    public Statement getStatement() {
        return statement;
    }
}
