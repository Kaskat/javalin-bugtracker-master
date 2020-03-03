package app.Util;

import app.Entities.Authorization.Authorization;
import io.javalin.http.Handler;

import java.util.Map;

import static app.Javalin.JavalinManager.tokenStorage;

public class Filters {



    public static Handler handleUserToken = ctx -> {
        if (ctx.sessionAttribute("token") == null) {
            ctx.status(403);
        }else {

            tokenStorage.get(ctx.sessionAttribute("token"));
            ctx.status(200);
        }
    };

}
