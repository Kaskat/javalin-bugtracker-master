package app.parser;

import app.Issue.Issue;
import app.Issue.IssueList;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class JsonToObjectTest {

    public IssueList setIssueList() {
        IssueList expected = new IssueList();

        Issue iss1 = new Issue(1,1,"0001", "name", "summary",
                "description", "assignee", "project");
        Issue iss2 = new Issue(2,2,"0002", "name2", "summary2",
                "description2", "assignee2", "project2");

        expected.addToIssues(iss1);
        expected.addToIssues(iss2);

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
