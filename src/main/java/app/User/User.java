package app.User;

public class User {
    String name;
    String userId;
    String lastName;
    String loginName;

    public User(){

    }

    public User(String userId, String name, String lastName, String loginName) {
        this.name = name;
        this.userId = userId;
        this.lastName = lastName;
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
