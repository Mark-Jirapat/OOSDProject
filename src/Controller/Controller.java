package Controller;

import Model.*;
import View.*;

public class Controller {

    Frame frame;
    Tools tools;
    UserDetail user;

    public void run() {
        frame = new Frame(new SignIn(this));
        tools = new Tools();
        user = null;
    }

    public void restart() {
        frame.add(new SignIn(this));
        user = null;
    }

    public void btnSignInOnSignIn(String userName, String password) {
        if (userName.isEmpty()) {
            tools.createMessageBox(frame, "User Name is empty.");
        } else if (password.isEmpty()) {
            tools.createMessageBox(frame, "Password is empty.");
        } else if (tools.isNotEnoughdigits(userName, 7)) {
            tools.createMessageBox(frame, "User Name need at least 7 letters.");
        } else if (tools.isNotEnoughdigits(password, 7)) {
            tools.createMessageBox(frame, "Password need at least 7 letters.");
        } else if (tools.getUserFromDatabase(userName, password) == null) {
            tools.createMessageBox(frame, "User not found in the system.");
        } else {
            user = tools.getUserFromDatabase(userName, password);
            tools.createSuccessBox(frame, "Log In Success");
            frame.changeCurrent(new Home(this));
        }
    }

    public void btnSignUpOnSignIn() {
        frame.changeCurrent(new SignUp(this));
    }

    public void btnConfirmOnSignUp(String userName, String password, String rePassword, String socialNo, String firstName, String lastName, int gender, String telephoneNo, String address) {
        if (userName.isEmpty()) {
            tools.createMessageBox(frame, "User Name is empty.");
        } else if (password.isEmpty()) {
            tools.createMessageBox(frame, "Password is empty.");
        } else if (rePassword.isEmpty()) {
            tools.createMessageBox(frame, "Re Password is empty.");
        } else if (socialNo.isEmpty()) {
            tools.createMessageBox(frame, "Social No is empty.");
        } else if (firstName.isEmpty()) {
            tools.createMessageBox(frame, "First Name is empty.");
        } else if (lastName.isEmpty()) {
            tools.createMessageBox(frame, "Last Name is empty.");
        } else if (telephoneNo.isEmpty()) {
            tools.createMessageBox(frame, "Telepohone No is empty.");
        } else if (address.isEmpty()) {
            tools.createMessageBox(frame, "Address is empty.");
        } else if (tools.isNotEnoughdigits(userName, 7)) {
            tools.createMessageBox(frame, "User Name need at least 7 letters.");
        } else if (tools.isNotEnoughdigits(password, 7)) {
            tools.createMessageBox(frame, "Password need at least 7 letters.");
        } else if (tools.isNotTheSame(password, rePassword)) {
            tools.createMessageBox(frame, "Password and Re Password are not the same.");
        } else if (tools.isNotANumber(socialNo)) {
            tools.createMessageBox(frame, "Social No need to be an only number.");
        } else if (tools.isNotNdigits(socialNo, 13)) {
            tools.createMessageBox(frame, "Social No need 13 letters.");
        } else if (tools.isNotANumber(telephoneNo)) {
            tools.createMessageBox(frame, "Telephone No need to be an only number.");
        } else if (tools.isNotNdigits(telephoneNo, 10)) {
            tools.createMessageBox(frame, "Telephone No need 10 letters.");
        } else if (tools.isHasUserNameInTheSystem(userName)) {
            tools.createMessageBox(frame, "User Name has already been used.");
        } else if (tools.isHasUserNameInTheSystem(socialNo)) {
            tools.createMessageBox(frame, "Social No has already been used.");
        } else {
            UserDetail user = new UserDetail(Integer.valueOf(socialNo), firstName, lastName, gender, telephoneNo, address, userName, password);
            user.addToDatabase();
            tools.createSuccessBox(frame, "Add New User Success");
            restart();
        }
    }

}
