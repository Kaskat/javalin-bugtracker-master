package app.Issue;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;

import static app.Main.*;

public class IssueController {

    public static Handler fetchAllIssue = ctx -> {
        ctx.json(issueDao.getTableIssue());
    };

    public static Handler fetchIssueByID = ctx -> {
        ctx.json(issueDao.getIssueByID(ctx.pathParam("id")));
    };

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
                    issue.getAssigneId()
            );
        } catch (Exception ex){
            ctx.result(ex.toString());
        }
    };

    public static Handler deleteIssue = ctx -> {
        issueDao.deleteIssue(ctx.pathParam("id"));
    };
}
