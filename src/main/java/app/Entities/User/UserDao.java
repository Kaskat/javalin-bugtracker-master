package app.Entities.User;

import app.DB.PostgreConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static app.DB.Query.*;

/**
 * Class for access to data of User objects
 */
public class UserDao {
    public static ArrayList<User> users;

    /**
     * Function to get all users from DB into ArrayList of User objects
     * @return ArrayList of User objects
     */
    public static ArrayList<User> getUsers()
    {
        users = new ArrayList<User>();
        try {
            Statement stmt = PostgreConnector.connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(SELECT_TABLE_USERS);

            while (resultSet.next()) {
                User tempUser = new User();

                String userId = resultSet.getString("user_id");
                String name = resultSet.getString("name");

                if(userId == null && name == null)// bad way
                    continue;

                tempUser.setUserId(userId);
                tempUser.setName(name);

                users.add(tempUser);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Function to get user from DB by login into ArrayList of User objects
     * @param login user's login
     * @return ArrayList of User objects
     */
    public static ArrayList<User> getUser(String login)
    {
        users = new ArrayList<User>();
        try {
            Statement stmt = PostgreConnector.connection.createStatement();
//            String d = SELECT_USER_BY_LOGIN(login);
            ResultSet resultSet = stmt.executeQuery(SELECT_USER_BY_LOGIN(login));

            while (resultSet.next()) {
                User tempUser = new User();

                String userId = resultSet.getString("user_id");
                String password = resultSet.getString("password");

                if(password == null && userId == null)// bad way
                    continue;

                tempUser.setUserId(userId);
                tempUser.setPassword(password);

                users.add(tempUser);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
