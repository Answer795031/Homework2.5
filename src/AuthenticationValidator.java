import java.util.regex.Pattern;

public class AuthenticationValidator {

    private static final Pattern p = Pattern.compile("^[A-Za-z0-9_]{1,20}$");

    public static void checkLogPass(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {

        checkLogin(login);
        checkPassword(password, confirmPassword);
    }

    public static void checkLogin(String login) throws WrongLoginException {

        if (!p.matcher(login).matches()) {
            throw new WrongLoginException("Логин может содержать только латинские символы, цифры и знак подчеркивания, и не может быть длиннее 20 символов!");
        }
    }

    public static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают!");
        }

        if (!p.matcher(password).matches()) {
            throw new WrongPasswordException("Пароль может содержать только латинские символы, цифры и знак подчеркивания, и не может быть длиннее 20 символов!");
        }
    }
}
