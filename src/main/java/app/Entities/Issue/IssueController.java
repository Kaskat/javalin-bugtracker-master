package app.Entities.Issue;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;

import java.util.ArrayList;

<<<<<<< HEAD
=======
import static app.Javalin.JavalinController.issueDao;

/**
 * Controller of issue class
 */
>>>>>>> 2df19134e9b8ecea23a77e00b79c1708be042c41
public class IssueController {

    /**
     * Function to get all issues
     */
    public static Handler fetchAllIssue = ctx -> {
        try{
            ArrayList<Issue> d = IssueDao.getTableIssue();
            if (d.size() > 0)        ctx.json(d);
        }
            catch (Exception ex){
                ctx.result(ex.toString());
        }
    };

    /**
     * Function to get the issue by its ID
     */
    public static Handler fetchIssueByID = ctx -> {
        ctx.json(IssueDao.getIssueByID(ctx.pathParam("id")));
    };

    /**
     * Function to insert the issue into DB
     */
    public static Handler insertIssue = ctx -> {
        try{
            ObjectMapper om = new ObjectMapper();

            Issue issue = om.readValue(ctx.body(), Issue.class);

            IssueDao.addIssue(
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
            IssueDao.updateIssue(
                    ctx.pathParam("id"),
                    issue.getSummary(),
                    issue.getDescription(),
                    issue.getPriorityId(),
                    issue.getStatusId(),
<<<<<<< HEAD
                    issue.getProject().getProjectId(),
                    issue.getAssignee().getUserId()
=======
                    issue.getProjectId(),
                    issue.getAssigneeId()
>>>>>>> 2df19134e9b8ecea23a77e00b79c1708be042c41
            );
        } catch (Exception ex){
            ctx.result(ex.toString());
        }
    };

    /**
     * Function to delete the issue from DB
     */
    public static Handler deleteIssue = ctx -> {
        IssueDao.deleteIssue(ctx.pathParam("id"));
    };
}
