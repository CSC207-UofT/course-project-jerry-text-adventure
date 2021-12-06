package presenter;

public class LoginPresenter extends Presenter {
    public void addLogin() {
        addToQueue("Login");
    }

    public void addSignup() {
        addToQueue("Signup");
    }

    public void addQuit() {
        addToQueue("Quit");
    }

    public void askForUsername() {
        System.out.print("Username: ");
    }

    public void askForPassword() {
        System.out.print("Password: ");
    }

    public void printInvalidUsernameOrPassword() {
        System.out.println("The username or password you entered is not valid.");
    }

    public void printInvalidPassword() {
        System.out.println("The password you entered is not valid.");
    }

    public void printUsernameExists() {
        System.out.println("The username you entered already exists.");
    }
}