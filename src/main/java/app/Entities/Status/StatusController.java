package app.Entities.Status;

import io.javalin.http.Handler;

import static app.Javalin.JavalinController.statusDao;


public class StatusController {

    public static Handler fetchAllStatus = ctx -> {
        ctx.json(statusDao.getStatuses());
    };
}
