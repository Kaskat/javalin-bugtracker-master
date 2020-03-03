package app.Entities.User;

import io.javalin.http.Handler;

<<<<<<< HEAD
=======
import static app.Javalin.JavalinController.userDao;

/**
 * Controller of User class
 */
>>>>>>> 2df19134e9b8ecea23a77e00b79c1708be042c41
public class UserController {
    /**
     * Function to get all users from DB
     */
    public static Handler fetchAllUser = ctx -> {
        try {
            ctx.json(UserDao.getUsers());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    };
}
