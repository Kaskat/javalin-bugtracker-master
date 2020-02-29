package app.Entities.User;


import io.javalin.http.Handler;

import static app.Javalin.JavalinController.userDao;

public class UserController {
    public static Handler fetchAllUser = ctx -> {
        ctx.json(userDao.getUsers());
    };
}
