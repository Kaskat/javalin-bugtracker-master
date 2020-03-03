package app.Entities.Project;

import io.javalin.http.Handler;

import static app.Javalin.JavalinController.projectDao;

/**
 * Controller of Project class
 */
public class ProjectController {

    /**
     * Function to get all projects from DB
     */
    public static Handler fetchAllProject = ctx -> {
        ctx.json(projectDao.getProjects());
    };
}
