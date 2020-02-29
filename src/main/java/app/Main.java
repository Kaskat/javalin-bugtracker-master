package app;

import app.Javalin.JavalinController;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;


import java.util.Properties;

import static io.javalin.apibuilder.ApiBuilder.*;


public class Main {
    public static void main(String[] args) {
        Properties properties = new Configuration("src/main/resources/config/configuration.yml").getProperties();
        int port = Integer.parseInt(properties.getProperty("port"));
        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/public");
            config.registerPlugin(new RouteOverviewPlugin("/routes"));
        }).start(getHerokuAssignedPort());

        JavalinController jvl = new JavalinController(app);
        jvl.start();
    }

    private static int getHerokuAssignedPort() {
        String herokuPort = System.getenv("PORT");
        if (herokuPort != null) {
            return Integer.parseInt(herokuPort);
        }
        return 7070;
    }

}


