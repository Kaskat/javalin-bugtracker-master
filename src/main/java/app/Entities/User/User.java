package app.Entities.User;

<<<<<<< HEAD
import app.Javalin.Roles;
import io.javalin.core.security.Role;

=======
/**
 * Class of user entity
 */
>>>>>>> 2df19134e9b8ecea23a77e00b79c1708be042c41
public class User {
    String name;
    String userId;
    String lastName;
    String loginName;

    String roleId;
    private String password;

    /**
     * Default constructor
     */
    public User(){

    }

    /**
     * User's name getter
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     * User's name setter
     * @param name user name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * User's ID getter
     * @return user ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * User's ID setter
     * @param userId user ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * User's last name getter
     * @return user last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * User's last name setter
     * @param lastName user last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * User's login name getter
     * @return user login name
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * User's login name setter
     * @param loginName user login name
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

<<<<<<< HEAD
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
=======
    /**
     * User's password getter
     * @param password user password
     */
    public void setPassword(String password) {
        this.password = password;
>>>>>>> 2df19134e9b8ecea23a77e00b79c1708be042c41
    }

    /**
     * User's password setter
     * @return user password
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role roleGet(){
        return Roles.values()[Integer.parseInt(getRoleId())];
    }
}
