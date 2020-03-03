package app.Entities.Status;

import io.javalin.http.Handler;

import static app.Javalin.JavalinController.statusDao;

/**
 * Controller of Status class
 */
public class StatusController {

    /**
     * Function to get all statuses from DB
     */
    public static Handler fetchAllStatus = ctx -> {
        ctx.json(statusDao.getStatuses());
    };
}
