package app.User;


import io.javalin.http.Handler;

import static app.Main.projectDao;
import static app.Main.userDao;

public class UserController {
    public static Handler fetchAllUser = ctx -> {
        ctx.json(userDao.getUsers());
    };

}
