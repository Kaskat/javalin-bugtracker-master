package app.Entities.Authorization;

import java.util.Objects;

/**
 * Class for user authorization
 */
public class Authorization {
    private String login;
    private String role;


    /**
     * Constructor of authorization class with parameters
     * @param login user's login
     * @param role user's role
     */
    public Authorization(String login, String role) {
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

    /**
     * User's role getter
     * @return user's role
     */
    public String getRole() {
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