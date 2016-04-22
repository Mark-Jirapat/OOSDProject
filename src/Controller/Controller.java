package Controller;

import Model.*;
import View.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;

public class Controller {

    Frame frame;
    Tools tools;
    UserDetail user;
    JPanel back;

    public void run() {
        frame = new Frame(new SignIn(this));
        //frame = new Frame(new ShowReservedAndCheckedIn(this, null));
        tools = new Tools();
        user = null;
        back = null;
    }

    public void restart() {
        frame.changeCurrent(new SignIn(this));
        user = null;
    }

    public void goToHome() {
        frame.changeCurrent(new Home(this));
    }

    public void goBack() {
        frame.changeCurrent(back);
    }

    public void error(String text) {
        tools.createMessageBox(frame, text);
    }

    public void btnSignInOnSignIn(String userName, String password) {
        if (userName.isEmpty()) {
            tools.createMessageBox(frame, "User Name is empty.");
        } else if (password.isEmpty()) {
            tools.createMessageBox(frame, "Password is empty.");
        } else if (tools.isNotInRangeOf(userName, 7, 13)) {
            tools.createMessageBox(frame, "User Name need 7-13 letters.");
        } else if (tools.isNotInRangeOf(password, 7, 13)) {
            tools.createMessageBox(frame, "Password need 7-13 letters.");
        } else {
            user = tools.getUserFromDatabase(userName, password);
            if (user == null) {
                tools.createMessageBox(frame, "User not found in the system.");
            } else {
                tools.createSuccessBox(frame, "Log In Success");
                frame.changeCurrent(new Home(this));
            }
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
        } else if (tools.isNotInRangeOf(userName, 7, 13)) {
            tools.createMessageBox(frame, "User Name need 7-13 letters.");
        } else if (tools.isNotInRangeOf(password, 7, 13)) {
            tools.createMessageBox(frame, "Password need 7-13 letters.");
        } else if (tools.isNotTheSame(password, rePassword)) {
            tools.createMessageBox(frame, "Password and Re Password are not the same.");
        } else if (tools.isNotANumber(socialNo)) {
            tools.createMessageBox(frame, "Social No need to be an only number.");
        } else if (tools.isNotNdigits(socialNo, 13)) {
            tools.createMessageBox(frame, "Social No need 13 letters.");
        } else if (socialNo.charAt(0) == '0') {
            tools.createMessageBox(frame, "Social No can not start with 0.");
        } else if (tools.isNotInRangeOf(firstName, 1, 20)) {
            tools.createMessageBox(frame, "First Name has to be least than or equal 20 letters.");
        } else if (tools.isNotInRangeOf(lastName, 1, 20)) {
            tools.createMessageBox(frame, "Last Name has to be least than or equal 20 letters.");
        } else if (tools.isNotANumber(telephoneNo)) {
            tools.createMessageBox(frame, "Telephone No need to be an only number.");
        } else if (tools.isNotNdigits(telephoneNo, 10)) {
            tools.createMessageBox(frame, "Telephone No need 10 letters.");
        } else if (tools.isHasUserNameInTheSystem(userName)) {
            tools.createMessageBox(frame, "User Name has already been used.");
        } else if (tools.isHasUserNameInTheSystem(socialNo)) {
            tools.createMessageBox(frame, "Social No has already been used.");
        } else {
            UserDetail user = new UserDetail(socialNo, firstName, lastName, gender, telephoneNo, address, userName, password);
            user.addToDatabase();
            tools.createSuccessBox(frame, "Add New User Success");
            restart();
        }
    }

    public void btnAddCustomerOnHome() {
        frame.changeCurrent(new AddCustomer(this));
    }

    public void btnShowCustomerOnHome() {
        ArrayList<CustomerDetail> customers = tools.getAllCustomerFromDatabase();
        JPanel panel = new ShowCustomer(this, customers);
        tools.setCustomersToTable(((ShowCustomer) panel).getTable(), customers);
        frame.changeCurrent(panel);
    }

    public void btnShowRoomOnHome() {
        ArrayList<Room> rooms = tools.getAllRoomFromDatabase();
        ArrayList<RoomType> roomTypes = tools.getAllRoomTypeFromDatabase();
        JPanel panel = new ShowRoom(this, rooms);
        tools.setRoomsToTable(((ShowRoom) panel).getTable(), rooms);
        tools.setRoomTypesToComboBox(((ShowRoom) panel).getCbbRoomType(), roomTypes);
        frame.changeCurrent(panel);
    }

    public void btnShowRestOnHome() {
        ArrayList<RestForm> rests = tools.getAllRestFromDatabase();
        JPanel panel = new ShowReservedAndCheckedIn(this, rests);
        tools.setRestsToTable(((ShowReservedAndCheckedIn) panel).getTable(), rests);
        frame.changeCurrent(panel);
    }

    public void btnEditProfileOnHome() {

    }

    public void btnConfirmOnAddCustomer(String socialNo, String firstName, String lastName, int gender, String telephoneNo, String address) {
        if (socialNo.isEmpty()) {
            tools.createMessageBox(frame, "Social No is empty.");
        } else if (firstName.isEmpty()) {
            tools.createMessageBox(frame, "First Name is empty.");
        } else if (lastName.isEmpty()) {
            tools.createMessageBox(frame, "Last Name is empty.");
        } else if (telephoneNo.isEmpty()) {
            tools.createMessageBox(frame, "Telepohone No is empty.");
        } else if (address.isEmpty()) {
            tools.createMessageBox(frame, "Address is empty.");
        } else if (tools.isNotANumber(socialNo)) {
            tools.createMessageBox(frame, "Social No need to be an only number.");
        } else if (tools.isNotNdigits(socialNo, 13)) {
            tools.createMessageBox(frame, "Social No need 13 letters.");
        } else if (socialNo.charAt(0) == '0') {
            tools.createMessageBox(frame, "Social No can not start with 0.");
        } else if (tools.isNotInRangeOf(firstName, 1, 20)) {
            tools.createMessageBox(frame, "First Name has to be least than or equal 20 letters.");
        } else if (tools.isNotInRangeOf(lastName, 1, 20)) {
            tools.createMessageBox(frame, "Last Name has to be least than or equal 20 letters.");
        } else if (tools.isNotANumber(telephoneNo)) {
            tools.createMessageBox(frame, "Telephone No need to be an only number.");
        } else if (tools.isNotNdigits(telephoneNo, 10)) {
            tools.createMessageBox(frame, "Telephone No need 10 letters.");
        } else if (tools.isHasSocialNoInTheSystem(socialNo)) {
            tools.createMessageBox(frame, "Social No has already been used.");
        } else {
            CustomerDetail customer = new CustomerDetail(socialNo, firstName, lastName, gender, telephoneNo, address);
            customer.addToDatabase();
            tools.createSuccessBox(frame, "Add New Customer Success");
            goToHome();
        }
    }

    public void btnSearchOnShowCustomer(JPanel panel, String text, int textType, int statusType) {
        ArrayList<CustomerDetail> customers = tools.searchCustomerFromDatabase(text, textType, statusType);
        ((ShowCustomer) panel).setCustomers(customers);
        tools.removeAllRow(((ShowCustomer) panel).getTable());
        tools.setCustomersToTable(((ShowCustomer) panel).getTable(), customers);
    }

    public void btnDetailOnShowCustomer(String socialNo, ArrayList<CustomerDetail> customers, JPanel back) {
        CustomerDetail customer = tools.getCustomerFromCustomerList(socialNo, customers);
        this.back = back;
        frame.changeCurrent(new ShowCustomerDetail(this, customer));
    }

    public void btnSearchOnShowRoom(JPanel panel, String roomNo, int floorNo, String roomTypeName) {
        ArrayList<Room> rooms = tools.searchRoomFromDatabase(roomNo, floorNo, roomTypeName);
        ((ShowRoom) panel).setRooms(rooms);
        tools.removeAllRow(((ShowRoom) panel).getTable());
        tools.setRoomsToTable(((ShowRoom) panel).getTable(), rooms);
    }
    
    public void btnSearchOnShowReservedAndCheckedIn(JPanel panel, int statusType, Date date, boolean isDateSelected){
        ArrayList<RestForm> rests = tools.searchRestFromDatabase(statusType, date, isDateSelected);
        ((ShowReservedAndCheckedIn) panel).setRests(rests);
        tools.removeAllRow(((ShowReservedAndCheckedIn) panel).getTable());
        tools.setRestsToTable(((ShowReservedAndCheckedIn) panel).getTable(), rests);
    }

}
