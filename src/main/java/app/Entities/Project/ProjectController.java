package app.Entities.Project;

import io.javalin.http.Handler;

import static app.Javalin.JavalinController.projectDao;


public class ProjectController {

    public static Handler fetchAllProject = ctx -> {
        ctx.json(projectDao.getProjects());
    };
}
