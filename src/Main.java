public class Main
{
    public static void main(String[] args) {

        String login = "login123_";
        String password = "password123_";
        String confirmPassword = "password123_";

        try{
            AuthenticationValidator.checkLogPass(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка выполнена");
        }

    }
}