package app.DB;
import app.Util.Configuration;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class PostgreConnector {
    Properties properties = new Configuration("src/main/resources/config/configuration.yml").getProperties();
    int port = Integer.parseInt(properties.getProperty("port"));

    /*
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "jenini250";
     */

    //  Database credentials
    final String DB_URL = "jdbc:postgresql://" + properties.getProperty("database_host") + ":"
            + properties.getProperty("database_port") + "/" + properties.getProperty("database_database");
    final String USER = properties.getProperty("database_user");
    final String PASS = properties.getProperty("database_password");

    static public Connection connection;

    public PostgreConnector() {
        Init();
    }

    public void Init() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
}