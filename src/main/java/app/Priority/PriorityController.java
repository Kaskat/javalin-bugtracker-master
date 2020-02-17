package app.Priority;

import io.javalin.http.Handler;

import static app.Main.priorityDao;

public class PriorityController {
    public static Handler fetchAllPriority = ctx -> {
        ctx.json(priorityDao.getPriority());
    };
}
