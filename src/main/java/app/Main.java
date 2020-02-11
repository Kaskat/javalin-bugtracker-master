package app;

import app.DB.PostgreConnector;
import app.Issue.IssueController;
import app.Issue.IssueDao;
import app.Util.Path;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;


import static io.javalin.apibuilder.ApiBuilder.*;


public class Main {

    public static IssueDao issueDao;
    public static PostgreConnector db = new PostgreConnector();

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public");
            config.registerPlugin(new RouteOverviewPlugin("/routes"));
        }).start(7070);
    }

}


