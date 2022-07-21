package model;

public class RegisterUser {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public RegisterUser withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisterUser withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public RegisterUser withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterUser withPassword(String password) {
        this.password = password;
        return this;
    }
}
