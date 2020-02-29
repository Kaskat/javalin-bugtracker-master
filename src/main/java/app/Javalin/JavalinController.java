package app.Javalin;

import app.DB.PostgreConnector;
import app.Entities.Authorization.Authorization;
import app.Entities.Issue.IssueController;
import app.Entities.Issue.IssueDao;
import app.Entities.Priority.PriorityController;
import app.Entities.Priority.PriorityDao;
import app.Entities.Project.ProjectController;
import app.Entities.Project.ProjectDao;
import app.Entities.Status.StatusController;
import app.Entities.Status.StatusDao;
import app.Entities.Type.TypeController;
import app.Entities.Type.TypeDao;
import app.Entities.User.UserController;
import app.Entities.User.UserDao;
import app.Util.Filters;
import app.Util.Path;
import io.javalin.Javalin;

import java.util.HashMap;
import java.util.Map;

import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinController {

    public static IssueDao issueDao;
    public static ProjectDao projectDao;
    public static PriorityDao priorityDao;
    public static TypeDao typeDao;
    public static StatusDao statusDao;
    public static UserDao userDao;

    public static PostgreConnector db = new PostgreConnector();

    AuthorizationController authController;

    Javalin app;
    public static Map<String, Authorization> tokenStorage;

    public JavalinController(Javalin app) {
        this.app = app;

        tokenStorage = new HashMap<>();

        authController = new AuthorizationController(tokenStorage);
    }
    public void start() {
        initRoutes();
    }

    public void initRoutes() {
        app.routes(() -> {

            app.error(404, ctx -> {
                ctx.status(404);
            });
            app.error(500, ctx -> {
                ctx.status(500);
            });
            app.error(505, ctx -> {
                ctx.status(505);
            });

            before(Filters.handleUserToken);

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

            post(Path.Web.LOGIN, authController.validateToken);
            get(Path.Web.VALIDATION, authController.validateToken);
        });
    }
}
