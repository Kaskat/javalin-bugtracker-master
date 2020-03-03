package app.Entities.Status;

import io.javalin.http.Handler;

<<<<<<< HEAD

=======
import static app.Javalin.JavalinController.statusDao;

/**
 * Controller of Status class
 */
>>>>>>> 2df19134e9b8ecea23a77e00b79c1708be042c41
public class StatusController {

    /**
     * Function to get all statuses from DB
     */
    public static Handler fetchAllStatus = ctx -> {
        ctx.json(StatusDao.getStatuses());
    };
}
