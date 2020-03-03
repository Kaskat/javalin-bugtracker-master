package app.Entities.Project;

import io.javalin.http.Handler;

<<<<<<< HEAD
=======
import static app.Javalin.JavalinController.projectDao;

/**
 * Controller of Project class
 */
>>>>>>> 2df19134e9b8ecea23a77e00b79c1708be042c41
public class ProjectController {

    /**
     * Function to get all projects from DB
     */
    public static Handler fetchAllProject = ctx -> {
        ctx.json(ProjectDao.getProjects());
    };
}
