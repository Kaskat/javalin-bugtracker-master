package app.Entities.Priority;

import io.javalin.http.Handler;

import static app.Javalin.JavalinController.priorityDao;

public class PriorityController {
    public static Handler fetchAllPriority = ctx -> {
        ctx.json(priorityDao.getPriority());
    };
}
