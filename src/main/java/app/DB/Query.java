package app.DB;

/**
 * Class that storing queries for the DB
 */
public class Query {
    public static final String SELECT_ALL_INFO_ISSUES
            = "select * from \"BugTracker\".\"Issue\"";
    public static final String SELECT_TABLE_INFO_ISSUES
            = "select issue_id, number, name from \"BugTracker\".\"Issue\"";

    public static final String SELECT_TABLE_PROJECTS
            = "select name, project_id from \"BugTracker\".\"Project\"";

    public static final String SELECT_TABLE_PRIORITY
            = "select name, priority_id from \"BugTracker\".\"Priority\"";

    public static final String SELECT_TABLE_STATUSES
            = "select name, status_id from \"BugTracker\".\"Status\"";

    public static final String SELECT_TABLE_TYPES
            = "select name, type_id from \"BugTracker\".\"Type\"";

    public static final String SELECT_TABLE_USERS
            = "select name, user_id from \"BugTracker\".\"User\"";

    public static final String SELECT_USER
            = "select user_id, login, password from \"BugTracker\".\"User\"";

    /**
     * Function that creating query to select the issue from DB by its ID
     * @param id issue's ID
     * @return query for DB search
     */
    public static String SELECT_ISSUE_BY_ID(String id)
    {
        return SELECT_ALL_INFO_ISSUES + "where issue_id = '" + id + "'";
    }

    /**
     * Function that creating query to insert the issue with its parameters into DB
     * @param summary issue's summary
     * @param description issue's description
     * @param priorityId issue's priorityId
     * @param statusId issue's statusId
     * @param projectId issue's projectId
     * @param assigneeId issue's assigneeId
     * @return query for DB insert
     */
    public static String INSERT_ISSUE_PARAMS
    (
        String summary,
        String description,
        String priorityId,
        String statusId,
        String projectId,
        String assigneeId
    )
    {
        StringBuffer insertBuffer = new StringBuffer("INSERT INTO \"BugTracker\".\"Issue\"(summary, description, priority_id, status_id, project_id, assigne_id) VALUES(");
            insertBuffer
                    .append("\'").append(summary).append("\', \'")
                    .append(description).append("\', ")
                    .append(priorityId).append(", ")
                    .append(statusId).append(", \'")
                    .append(projectId).append("\', \'")
                    .append(assigneeId).append("\')");

        return  insertBuffer.toString();
    }

    /**
     * Function that creating query to update the issue by its ID in DB
     * @param id issue's ID
     * @param summary new issue's summary value to update
     * @param description new issue's description value to update
     * @param priorityId new issue's priorityId value to update
     * @param statusId new issue's statusId value to update
     * @param projectId new issue's projectId value to update
     * @param assigneeId new issue's assigneeId value to update
     * @return query for DB value update
     */
    public static String UPDATE_ISSUE_BY_ID
    (
        String id,
        String summary,
        String description,
        String priorityId,
        String statusId,
        String projectId,
        String assigneeId
    )
    {
        StringBuffer updateBuffer = new StringBuffer("UPDATE \"BugTracker\".\"Issue\"SET ");
        updateBuffer
                .append("summary= \'").append(summary).append("\', ")
                .append("description= \'").append(description).append("\', ")
                .append("priority_id= ").append(priorityId).append(", ")
                .append("status_id= ").append(statusId).append(", ")
                .append("project_id= \'").append(projectId).append("\', ")
                .append("assigne_id= \'").append(assigneeId).append("\'")
        .append("WHERE issue_id= \'").append(id).append("\'");

        return  updateBuffer.toString();
    }

    /**
     * Function that creating query to delete the issue by its ID in DB
     * @param id issue's ID
     * @return query for DB issue delete
     */
    public static String DELETE_ISSUE_BY_ID
    (
        String id
    )
    {
        StringBuffer deleteBuffer = new StringBuffer("DELETE FROM \"BugTracker\".\"Issue\"");
        deleteBuffer
                .append("WHERE issue_id= \'").append(id).append("\'");

        return deleteBuffer.toString();
    }

    /**
     * Function that creating query to select the user from DB by its login
     * @param login user's login
     * @return query for DB search
     */
    public static String SELECT_USER_BY_LOGIN(String login)
    {
        return SELECT_USER + "where login = '" + login + "'";
    }


}
