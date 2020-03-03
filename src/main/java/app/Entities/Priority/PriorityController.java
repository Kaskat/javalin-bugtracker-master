package app.Entities.Priority;

import io.javalin.http.Handler;

<<<<<<< HEAD
=======
import static app.Javalin.JavalinController.priorityDao;

/**
 * Controller class of Priority class
 */
>>>>>>> 2df19134e9b8ecea23a77e00b79c1708be042c41
public class PriorityController {
    /**
     * Function to get all priorities objects
     */
    public static Handler fetchAllPriority = ctx -> {
        ctx.json(PriorityDao.getPriority());
    };
}
