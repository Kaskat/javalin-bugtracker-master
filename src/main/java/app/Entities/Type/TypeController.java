package app.Entities.Type;

import io.javalin.http.Handler;
import static app.Main.*;

/**
 * Controller of Type class
 */
public class TypeController {

    /**
     * Function to get all types from DB
     */
    public static Handler fetchAllType = ctx -> {
        ctx.json(TypeDao.getTypes());
    };
}
