package app.Javalin;

import app.Entities.Authorization.Authorization;
import app.Entities.Issue.Issue;
import app.Entities.User.User;
import app.Entities.User.UserController;
import app.Entities.User.UserDao;
import app.Security.JWTProvider;
import app.Security.JavalinJWT;
import app.Security.UserProvider;
import app.Util.Hash;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Handler;

import java.util.ArrayList;
import java.util.Map;

public class AuthorizationController {

    private static Map<String, Authorization> tokenStorage;

    private static JWTProvider provider;
    private static Handler decodeHandler;

    public AuthorizationController(Map<String, Authorization> tokenStorage) {
        this.tokenStorage = tokenStorage;

        provider = UserProvider.createHMAC512();
        decodeHandler = JavalinJWT.createHeaderDecodeHandler(provider);
    }

    public static Handler validateToken = ctx -> {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(ctx.body());

        final String login = node.get("login").asText();
        final String password = new Hash(node.get("password").asText()).getHash();

        if (!login.matches("[\\w-_]{" + login.length() + "}")) {
            ctx.result("Login must contain only [a-z0-9_-].");
            return;
        }

        if (login.matches("[а-яА-ЯЄєІіїЇҐґ]+")) {
            ctx.result("The login should contain only English words.");
            return;
        }

        ArrayList<User> users = UserDao.getUser(login);
        int count = users.size();
        User tempUser = null;

        for (int i = 0; i < count; i++){
            tempUser = users.get(i);

            if(tempUser.getPassword().equals(password)) {
                break;
            }
            tempUser = null;
        }

        if(tempUser == null) {
            ctx.result("You entered incorrect login/password");
            return;
        }

        String token = provider.generateToken(tempUser);
        ctx.sessionAttribute("token", token);
        tokenStorage.put(token, new Authorization(login, "Role"));

        ctx.result(token);
        ctx.status(200);
    };

//    public static Handler validateToken = ctx -> {
////        Optional<DecodedJWT> decodedJWT = JavalinJWT.getTokenFromHeader(context)
////                    .flatMap(provider::validateToken);
////
////            if (!decodedJWT.isPresent()) {
////                context.status(401).result("Missing or invalid token");
////            }
////            else {
////                context.result("Hi " + decodedJWT.get().getClaim("name").asString());
////            }
//    };


//    public void CheckAuthorization(String login, String password)
//    {
//
//    }

}
