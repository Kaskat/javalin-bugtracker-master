package app.Security;

import com.auth0.jwt.interfaces.DecodedJWT;
import io.javalin.core.security.AccessManager;
import io.javalin.core.security.Role;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class JWTAccessManager implements AccessManager {
    private String userRoleClaim;
    private Map<String, String> rolesMapping;
    private String defaultRole;

    public JWTAccessManager(String userRoleClaim, Map<String, String> rolesMapping, String defaultRole) {
        this.userRoleClaim = userRoleClaim;
        this.rolesMapping = rolesMapping;
        this.defaultRole = defaultRole;
    }

    private String extractRole(Context context) {
        if (!JavalinJWT.containsJWT(context)) {
            return defaultRole;
        }

        DecodedJWT jwt = JavalinJWT.getDecodedFromContext(context);
        String userLevel = jwt.getClaim(userRoleClaim).asString();

        return Optional.ofNullable(rolesMapping.get(userLevel)).orElse(defaultRole);
    }

    @Override
    public void manage(Handler handler, Context context, Set<Role> permittedRoles) throws Exception {
        String role = extractRole(context);

        if (permittedRoles.contains(role)) {
            handler.handle(context);
        } else {
            context.status(401).result("Unauthorized");
        }
    }
}