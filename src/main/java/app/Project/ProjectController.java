package app.Project;

import io.javalin.http.Handler;

import static app.Main.projectDao;


public class ProjectController {

    public static Handler fetchAllProject = ctx -> {
        ctx.json(projectDao.getProjects());
    };
}
