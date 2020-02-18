package app.Issue;

import app.Project.Project;
import app.User.User;
import org.hamcrest.core.Is;
import org.junit.*;
import app.Issue.IssueDao;

public class IssueDaoTest {
    User user = new User("0001", "Test", "TestLast", "TestLogin");
    Project project = new Project("1", "Name1");
    Issue expected = new Issue("summary",
            "description", "1", "1", project, user);

    @Test
    public void addIssueTest() {
        IssueDao.addIssue("summary", "description", "1", "1", project.getProjectId(), user.getUserId());

        IssueDao dao = new IssueDao();
        Issue actual = dao.selectIssue("summary", project);

        Assert.assertEquals("Not equal", expected, actual);
    }

    @Test
    public void editIssueTest() {
        Issue exp = new Issue("summary edited",
                "description edited", "1", "1", project, user);
        IssueDao.addIssue("summary", "description", "1", "1", project.getProjectId(), user.getUserId());

        IssueDao dao = new IssueDao();
        Issue actual = dao.selectIssue("summary", project);
        IssueDao.updateIssue(actual.getId(), "summary edited", "description edited", "1", "1", project.getProjectId(), user.getUserId());

        actual = dao.selectIssue("summary edited", project);
        Assert.assertEquals("Not equal", exp, actual);
    }

    @Test(expected = NullPointerException.class)
    public void deleteIssueTest() {
        IssueDao.addIssue("summary", "description", "1", "1", project.getProjectId(), user.getUserId());

        IssueDao dao = new IssueDao();
        Issue actual = dao.selectIssue("summary", project);

        IssueDao.deleteIssue(actual.getId());
    }
}
