package app.parser;

import app.Issue.Issue;
import app.Issue.IssueList;
import app.Project.Project;
import app.User.User;
import org.hamcrest.CoreMatchers;
import org.junit.*;

import java.io.IOException;

public class JsonToObjectTest {

    public IssueList setIssueList() {
        IssueList expected = new IssueList();

        User user = new User("0001", "Test", "TestLast", "TestLogin");
        Project project = new Project("1", "Name1");
        Issue iss1 = new Issue("summary",
                "description", "1", "1", project, user);

        expected.addToIssues(iss1);

        return expected;
    }

    @Test
    public void getObject () throws IOException {
        IssueList list = JsonToObject.parseObject();

        String match = setIssueList().toString();
        String actual = list.toString();
        //assertEquals("Objects are not equals!", setIssueList(), list);
        Assert.assertThat("Objects are not equals!", actual, CoreMatchers.containsString(match));
    }
}
