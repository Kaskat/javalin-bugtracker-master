package app;

import app.DB.PostgreConnector;
import app.Issue.IssueController;
import app.Issue.IssueDao;
import app.Priority.PriorityController;
import app.Priority.PriorityDao;
import app.Project.ProjectController;
import app.Project.ProjectDao;
import app.Status.StatusController;
import app.Status.StatusDao;
import app.Type.TypeController;
import app.Type.TypeDao;
import app.User.UserController;
import app.User.UserDao;
import app.Util.Configuration;
import app.Util.Path;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;


import java.util.Properties;

import static io.javalin.apibuilder.ApiBuilder.*;


public class Main {

    public static IssueDao issueDao;
    public static ProjectDao projectDao;
    public static PriorityDao priorityDao;
    public static TypeDao typeDao;
    public static StatusDao statusDao;
    public static UserDao userDao;

    public static PostgreConnector db = new PostgreConnector();

    public static void main(String[] args) {
        Properties properties = new Configuration("src/main/resources/config/configuration.yml").getProperties();
        int port = Integer.parseInt(properties.getProperty("port"));
        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public");
            config.registerPlugin(new RouteOverviewPlugin("/routes"));
        }).start(port);



        app.routes(() -> {
            get(Path.Web.ISSUE, IssueController.fetchAllIssue);

            get(Path.Web.ONE_ISSUE, IssueController.fetchIssueByID);
            post(Path.Web.ISSUE, IssueController.insertIssue);
            patch(Path.Web.ONE_ISSUE, IssueController.updateIssue);
            delete(Path.Web.ONE_ISSUE, IssueController.deleteIssue);

            get(Path.Web.PROJECTS, ProjectController.fetchAllProject);
            get(Path.Web.PRIORITY, PriorityController.fetchAllPriority);
            get(Path.Web.STATUS, StatusController.fetchAllStatus);
            get(Path.Web.TYPES, TypeController.fetchAllType);

            get(Path.Web.USERS, UserController.fetchAllUser);
        });
    }

}


