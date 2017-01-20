package Logic;

public class User {
    
    private String username;
    private String password;
    
    public User (String username, String password ) {
        
        this.username = username;
        this.password = password;
    }
    
    
    @Override
    public String toString() {
        return "User { " + username + "password: " + password + "}";
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
}
