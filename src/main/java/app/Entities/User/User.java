package app.Entities.User;

/**
 * Class of user entity
 */
public class User {
    String name;
    String userId;
    String lastName;
    String loginName;
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

    /**
     * User's password getter
     * @param password user password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * User's password setter
     * @return user password
     */
    public String getPassword() {
        return password;
    }
}
