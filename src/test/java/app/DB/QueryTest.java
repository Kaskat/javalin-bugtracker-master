package app.DB;
import app.Issue.Issue;
import app.Issue.IssueDao;
import app.Project.Project;
import app.User.User;
import org.junit.*;

public class QueryTest {
    User user = new User("0001", "Test", "TestLast", "TestLogin");
    Project project = new Project("1", "Name1");

    @Test
    public void selectIssueById() {
        String actual = Query.SELECT_ISSUE_BY_ID("001");
        String expected = "select * from \"BugTracker\".\"Issue\" where issue_id = \'001\';";

        Assert.assertEquals("Not equal", expected, actual);
    }

    @Test
    public void insertIssueParamsTest() {
        String actual = Query.INSERT_ISSUE_PARAMS("summary", "description", "1",
                "1", project.getProjectId(), user.getUserId());
        String expected = "INSERT INTO \"BugTracker\".\"Issue\"(summary, description, priority_id, status_id, " +
                "project_id, assigne_id) VALUES(\'summary\', \'description\', 1, 1, \'1\', \'0001\');";

        Assert.assertEquals("Not equal", expected, actual);
    }

    @Test
    public void updateUserById() {
        String actual = Query.UPDATE_ISSUE_BY_ID("id", "summary edited",
                "description edited", "1",
                "1", project.getProjectId(), user.getUserId());

        StringBuffer updateBuffer = new StringBuffer("UPDATE \"BugTracker\".\"Issue\"SET ");
        updateBuffer
                .append("summary= \'").append("summary edited").append("\', ")
                .append("description= \'").append("description edited").append("\', ")
                .append("priority_id= ").append("1").append(", ")
                .append("status_id= ").append("1").append(", ")
                .append("project_id= \'").append(project.getProjectId()).append("\', ")
                .append("assigne_id= \'").append(user.getUserId()).append("\'")
                .append("WHERE issue_id= \'").append("id").append("\';");
        String expected = updateBuffer.toString();

        Assert.assertEquals("Not equal", expected, actual);
    }

    @Test
    public void deleteIssueById() {
        String actual = Query.DELETE_ISSUE_BY_ID("id");
        String expected = "DELETE FROM \"BugTracker\".\"Issue\" WHERE issue_id= \'id\';";
        Assert.assertEquals("Not equal", expected, actual);
    }
}
