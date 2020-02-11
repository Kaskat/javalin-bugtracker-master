package app.DB;

public class Query {
    public static final String SELECT_ALL_INFO_ISSUES
            = "select * from \"BugTracker\".\"Issue\"";
    public static final String SELECT_TABLE_INFO_ISSUES
            = "select issue_id, number, name from \"BugTracker\".\"Issue\"";

    public static String SELECT_ISSUE_BY_ID(String id) {
        return SELECT_ALL_INFO_ISSUES + "where issue_id = '" + id + "'";
    }

}
