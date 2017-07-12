package database;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Sem on 09-Jul-17.
 */
public class Repository {
    static Connection connection;
    static String connectionString = "";

    public static void connectToDatabase() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mockupcitytours", Credentials.getUser(), Credentials.getPwd());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(final String statement) throws SQLException {
        Statement command = connection.createStatement();
        System.out.println("Executing Query:");
        System.out.println(statement);
        return command.executeQuery(statement);
    }

    public static void executeUpdate(final String statement) throws SQLException {
        Statement command = connection.createStatement();
        System.out.println("Executing Query:");
        System.out.println(statement);
        command.executeUpdate(statement);
    }

    public static void executeStatement(final String statement) throws SQLException {
        Statement command = connection.createStatement();
        System.out.println("Executing Query:");
        System.out.println(statement);
        command.execute(statement);
    }

}
