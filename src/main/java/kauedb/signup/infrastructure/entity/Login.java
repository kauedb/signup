package kauedb.signup.infrastructure.entity;

public class Login {

    private final String login, password;

    private Login(final String login, final String password) {
        this.login = login;
        this.password = password;
    }

    public static Login login(final String login, final String password) {
        return new Login(login, password);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
