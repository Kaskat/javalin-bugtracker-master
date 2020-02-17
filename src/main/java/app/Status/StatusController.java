package app.Status;

import io.javalin.http.Handler;

import static app.Main.statusDao;

public class StatusController {

    public static Handler fetchAllStatus = ctx -> {
        ctx.json(statusDao.getStatuses());
    };
}
