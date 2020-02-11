package app.Issue;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;

import java.io.StringWriter;

import static app.Main.*;

public class IssueController {

    public static Handler fetchAllIssue = ctx -> {
        ctx.json(issueDao.getTableIssue());
    };

    public static Handler fetchIssueByID = ctx -> {
        ctx.json(issueDao.getIssueByID(ctx.pathParam("id")));
    };
}
