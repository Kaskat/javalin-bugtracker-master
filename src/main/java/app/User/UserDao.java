package app.User;

import app.DB.PostgreConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static app.DB.Query.SELECT_TABLE_USERS;

public class UserDao {
    public static ArrayList<User> users;

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
}
