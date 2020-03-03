package app.Entities.Issue;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;

import java.util.ArrayList;

import static app.Javalin.JavalinController.issueDao;

/**
 * Controller of issue class
 */
public class IssueController {

    /**
     * Function to get all issues
     */
    public static Handler fetchAllIssue = ctx -> {
        ArrayList<Issue> d = issueDao.getTableIssue();
        if (d.size() > 0)        ctx.json(d);
        else ctx.status(303);

    };

    /**
     * Function to get the issue by its ID
     */
    public static Handler fetchIssueByID = ctx -> {
        ctx.json(issueDao.getIssueByID(ctx.pathParam("id")));
    };

    /**
     * Function to insert the issue into DB
     */
    public static Handler insertIssue = ctx -> {
        try{
            ObjectMapper om = new ObjectMapper();

            Issue issue = om.readValue(ctx.body(), Issue.class);

            issueDao.addIssue(
                    issue.getSummary(),
                    issue.getDescription(),
                    issue.getPriorityId(),
                    issue.getStatusId(),
                    issue.getProject().getProjectId(),
                    issue.getAssignee().getUserId()
            );
        }
        catch(Exception ex){
            ex.printStackTrace();
            ctx.result(ex.toString());
        }
    };

    /**
     * Function to update the issue in DB
     */
    public  static Handler updateIssue = ctx -> {
        ObjectMapper om = new ObjectMapper();

        Issue issue = om.readValue(ctx.body(), Issue.class);
        try{
            issueDao.updateIssue(
                    ctx.pathParam("id"),
                    issue.getSummary(),
                    issue.getDescription(),
                    issue.getPriorityId(),
                    issue.getStatusId(),
                    issue.getProjectId(),
                    issue.getAssigneeId()
            );
        } catch (Exception ex){
            ctx.result(ex.toString());
        }
    };

    /**
     * Function to delete the issue from DB
     */
    public static Handler deleteIssue = ctx -> {
        issueDao.deleteIssue(ctx.pathParam("id"));
    };
}
