package app.Type;

import io.javalin.http.Handler;

import static app.Main.*;

public class TypeController {

    public static Handler fetchAllType = ctx -> {
        ctx.json(typeDao.getTypes());
    };
}
