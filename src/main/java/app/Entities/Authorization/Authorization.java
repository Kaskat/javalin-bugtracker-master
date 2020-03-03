package app.Entities.Authorization;


import io.javalin.core.security.Role;

import java.util.Objects;

/**
 * Class for user authorization
 */
public class Authorization {
    private String login;
    private Role role;


<<<<<<< HEAD
    public Authorization(String login, Role role) {
=======
    /**
     * Constructor of authorization class with parameters
     * @param login user's login
     * @param role user's role
     */
    public Authorization(String login, String role) {
>>>>>>> 2df19134e9b8ecea23a77e00b79c1708be042c41
        this.login = login;
        this.role = role;
    }


    /**
     * User's login getter
     * @return user's login
     */
    public String getLogin() {
        return login;
    }

<<<<<<< HEAD
    public Role getRole() {
=======
    /**
     * User's role getter
     * @return user's role
     */
    public String getRole() {
>>>>>>> 2df19134e9b8ecea23a77e00b79c1708be042c41
        return role;
    }

    @Override
    public String toString() {
        return "Authorization{"
                + "login='" + login + '\''
                + ", role=" + role
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Authorization that = (Authorization) o;
        return Objects.equals(login, that.login) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, role);
    }
}