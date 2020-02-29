package app.Javalin;

import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.get;

public class RouteController {
    private Javalin app;


    public RouteController(Javalin app) {
        this.app = app;
    }



}
