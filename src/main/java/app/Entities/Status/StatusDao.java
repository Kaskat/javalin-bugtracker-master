package app.Entities.Status;

import app.DB.PostgreConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static app.DB.Query.SELECT_TABLE_STATUSES;

/**
 * Class for access to data of Status objects
 */
public class StatusDao {

    public static ArrayList<Status> statuses;

    /**
     * Function to get all statuses from DB into ArrayList of Status objects
     * @return ArrayList of Status objects
     */
    public static ArrayList<Status> getStatuses()
    {
        statuses = new ArrayList<Status>();
        try {
            Statement stmt = PostgreConnector.connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(SELECT_TABLE_STATUSES);

            while (resultSet.next()) {
                Status tempProject = new Status();

                String statusId = resultSet.getString("status_id");
                String name = resultSet.getString("name");

                if(statusId == null && name == null)// bad way
                    continue;

                tempProject.setStatusId(statusId);
                tempProject.setStatusName(name);

                statuses.add(tempProject);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }
}
