package app.Entities.Priority;

import io.javalin.http.Handler;

import static app.Javalin.JavalinController.priorityDao;

/**
 * Controller class of Priority class
 */
public class PriorityController {
    /**
     * Function to get all priorities objects
     */
    public static Handler fetchAllPriority = ctx -> {
        ctx.json(priorityDao.getPriority());
    };
}
