package app.parser;

import app.Issue.Issue;
import app.Issue.IssueList;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

public class ObjectToJsonTest {
    public IssueList setIssueList() {
        IssueList expected = new IssueList();

        /*Issue iss1 = new Issue(1,1,"0001", "name", "summary",
                "description", "assignee", "project");
        Issue iss2 = new Issue(2,2,"0002", "name2", "summary2",
                "description2", "assignee2", "project2");

        expected.addToIssues(iss1);
        expected.addToIssues(iss2);*/

        return expected;
    }

    @Test
    public void getJson () throws IOException {
        String par = ObjectToJson.parser(setIssueList());
        ObjectToJson.toFile(par);

        File file1 = new File("src/main/resources/json/example.json");
        File file2 = new File("src/main/resources/json/main.json");
        assertEquals("The files differ!",
                FileUtils.readFileToString(file1, "utf-8"),
                FileUtils.readFileToString(file2, "utf-8"));
    }
}
