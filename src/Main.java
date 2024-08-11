import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    private static final String VALID_SYMBOLS = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890_";
    public static void main(String[] args) {
        try {
            authenticateUser("123", "456/", "456");
        } catch (WrongLoginException | WrongPasswordException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void authenticateUser(String login, String password, String repeatPassword){
        if (login.length() > 20) {
            throw new WrongLoginException("Long login!");
        }
        for (int i = 0; i < login.length(); i++) {
            if (!VALID_SYMBOLS.contains(Character.toString(login.charAt(i)))){
                throw new WrongLoginException("Wrong login!");
            }
        }

        if (password.length() > 20) {
            throw new WrongPasswordException("Long password!");
        }
        for (int i = 0; i < password.length(); i++) {
            if (!VALID_SYMBOLS.contains(Character.toString(password.charAt(i)))){
                throw new WrongPasswordException("Wrong password!");
            }
        }

        if (!password.equals(repeatPassword)) {
            throw new WrongPasswordException("Passwords don't match");
        }
    }


}
