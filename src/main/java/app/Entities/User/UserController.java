package app.Entities.User;

import io.javalin.http.Handler;

import static app.Javalin.JavalinController.userDao;

/**
 * Controller of User class
 */
public class UserController {
    /**
     * Function to get all users from DB
     */
    public static Handler fetchAllUser = ctx -> {
        ctx.json(userDao.getUsers());
    };
}
