import java.util.regex.Pattern;
public class Main
{
    public static void main(String[] args) {

        String login = "login123_";
        String password = "password123_";
        String confirmPassword = "password123_";

        try{
            checkLogPass(login, password, confirmPassword);
        } catch (WrongLoginException e){
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка выполнена");
        }

    }

    public static void checkLogPass(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {

        checkLogin(login);
        checkPassword(password, confirmPassword);
    }

    public static void checkLogin(String login) throws WrongLoginException {

        int maxLoginLength = 20;

        if (login.length() > maxLoginLength){
            throw new WrongLoginException(String.format("Длина логина не должна превышать %s символов!", maxLoginLength));
        }

        Pattern p = Pattern.compile("^[A-Za-z0-9_]{1,20}$");
        if (!p.matcher(login).matches()) {
            throw new WrongLoginException("Логин может содержать только латинские символы, цифры и знак подчеркивания!");
        }
    }

    public static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {

        int maxPasswordLength = 20;

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают!");
        }

        if (password.length() > maxPasswordLength){
            throw new WrongPasswordException(String.format("Длина пароля не должна превышать %s символов!", maxPasswordLength));
        }

        Pattern p = Pattern.compile("^[A-Za-z0-9_]{1,20}$");
        if (!p.matcher(password).matches()) {
            throw new WrongPasswordException("Пароль может содержать только латинские символы, цифры и знак подчеркивания!");
        }
    }
}