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
    Date currentDate;

    public void run() {
        frame = new Frame(new SignIn(this));
        tools = new Tools();
        user = null;
        currentDate = tools.getCurrentDate();
        System.out.println("*** CURRENT DATE IS " + currentDate.getDate() + "/" + (currentDate.getMonth() + 1) + "/" + (currentDate.getYear() + 1900) + " ***");
        tools.removeExpiredReserveFromDatebase(currentDate);
    }

    public void restart() {
        frame.changeCurrent(new SignIn(this));
        user = null;
        currentDate = tools.getCurrentDate();
        System.out.println("*** CURRENT DATE IS " + currentDate.getDate() + "/" + (currentDate.getMonth() + 1) + "/" + (currentDate.getYear() + 1900) + " ***");
        tools.removeExpiredReserveFromDatebase(currentDate);
    }

    public void goToHome() {
        frame.changeCurrent(new Home(this));
    }

    public void goBack(JPanel back) {
        frame.changeCurrent(back);
    }

    public void error(String text) {
        tools.createMessageBox(frame, text);
    }

    // -- SIGN IN & SIGN UP --
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

    // -- HOME --
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
        frame.changeCurrent(new EditProfile(this, user));
    }

    // -- ADD CUSTOMER --
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

    // -- SHOW CUSTOMER --
    public void btnSearchOnShowCustomer(JPanel panel, String text, int textType, int statusType) {
        ArrayList<CustomerDetail> customers = tools.searchCustomerFromDatabase(text, textType, statusType);
        ((ShowCustomer) panel).setCustomers(customers);
        tools.removeAllRow(((ShowCustomer) panel).getTable());
        tools.setCustomersToTable(((ShowCustomer) panel).getTable(), customers);
    }

    public void btnDetailOnShowCustomer(String socialNo, ArrayList<CustomerDetail> customers, JPanel back) {
        CustomerDetail customer = tools.getCustomerFromCustomerList(socialNo, customers);
        frame.changeCurrent(new ShowCustomerDetail(this, customer, back));
    }

    // -- SHOW CUSTOMER DETAIL --
    public void btnCommand1OnShowCustomerDetail(CustomerDetail customer, JPanel back) {
        if (customer.getStatus() == -1) {
            RestForm rest = new CheckInForm(customer);
            frame.changeCurrent(new GeneralDetail(this, rest, currentDate, back));
        } else {
            RestForm rest = tools.getRestFromDatabase(customer.getSocialNo());
            JPanel panel = new ConfirmationAndDetail(this, rest, 1, back);
            tools.setRoomsToTable(((ConfirmationAndDetail) panel).getTable(), rest.getRooms());
            frame.changeCurrent(panel);
        }
    }

    public void btnCommand2OnShowCustomerDetail(CustomerDetail customer, JPanel back) {
        RestForm rest = new ReserveForm(customer);
        frame.changeCurrent(new GeneralDetail(this, rest, currentDate, back));
    }

    // -- GENERAL DETAIL --
    public void btnNextOnGeneralDetail(RestForm rest, String amountOfPeople, Date startDate, Date endDate, JPanel back) {
        if (amountOfPeople.isEmpty()) {
            tools.createMessageBox(frame, "Amount of People is empty.");
        } else if (tools.isNotANumber(amountOfPeople)) {
            tools.createMessageBox(frame, "Amount of People need to be a number.");
        } else if (Integer.parseInt(amountOfPeople) <= 0) {
            tools.createMessageBox(frame, "Amount of People can not be 0.");
        } else if (startDate.after(endDate)) {
            tools.createMessageBox(frame, "End Date can not start before Start Date.");
        } else if (currentDate.after(startDate)) {
            tools.createMessageBox(frame, "Start Date can not start before Current Date.");
        } else {
            rest.setAmountOfPeople(Integer.parseInt(amountOfPeople));
            rest.setStartDate(startDate);
            rest.setEndDate(endDate);
            ArrayList<Room> rooms = tools.getAvialableRoomFromDatabase(startDate, endDate);
            JPanel panel = new SelectRoom(this, rooms, rest, back);
            tools.setRoomsToTable(((SelectRoom) panel).getTable(), rooms);
            frame.changeCurrent(panel);
        }
    }

    // -- SELECT ROOM --
    public void btnNextOnSelectRoom(RestForm rest, int bed, ArrayList<Room> rooms, ArrayList<Integer> selectedRoomNo, JPanel back) {
        if (bed < rest.getAmountOfPeople()) {
            tools.createMessageBox(frame, "Amount of bed is less than amount of people.");
        } else {
            ArrayList<Room> selectedRooms = tools.getRoomListFromRoomList(rooms, selectedRoomNo);
            rest.setRooms(selectedRooms);
            JPanel panel = new ConfirmationAndDetail(this, rest, 0, back);
            tools.setRoomsToTable(((ConfirmationAndDetail) panel).getTable(), selectedRooms);
            frame.changeCurrent(panel);
        }
    }

    // -- CONFIRMATION AND DETAIL --
    public void btnCommand1OnConfirmationAndDetail(RestForm rest, int type) {
        if (type == 0) {
            rest.addToDatabase();
            if (rest.getStatus() == 0) {
                tools.createSuccessBox(frame, "Check In Success.");
            } else if (rest.getStatus() == 1) {
                tools.createSuccessBox(frame, "Reserve Success.");
            }
        } else if (type == 1 && rest.getStatus() == 0) {
            //check out
            tools.createSuccessBox(frame, "Check Out Success.");
        } else if (type == 1 && rest.getStatus() == 1) {
            rest.setStatus(0);
            rest.updateToDatabase();
            tools.createSuccessBox(frame, "Check In Success.");
        }
        goToHome();
    }

    public void btnCommand2OnConfirmationAndDetail(RestForm rest) {
        rest.deleteFromDatabase();
        tools.createSuccessBox(frame, "Cancel Reserve Success.");
        goToHome();
    }

    // -- SHOW ROOM --
    public void btnSearchOnShowRoom(JPanel panel, String roomNo, int floorNo, String roomTypeName) {
        ArrayList<Room> rooms = tools.searchRoomFromDatabase(roomNo, floorNo, roomTypeName);
        ((ShowRoom) panel).setRooms(rooms);
        tools.removeAllRow(((ShowRoom) panel).getTable());
        tools.setRoomsToTable(((ShowRoom) panel).getTable(), rooms);
    }

    public void btnDetailOnShowRoom(int roomNo, ArrayList<Room> rooms, JPanel back) {
        Room room = tools.getRoomFromRoomList(roomNo, rooms);
        RoomDetail roomDetail = new RoomDetail(room);
        roomDetail.setAllDetailFromDatabase();
        JPanel panel = new ShowRoomDetail(this, roomDetail, back);
        tools.setReservedListToTable(((ShowRoomDetail) panel).getTable(), roomDetail.getReservedRests());
        frame.changeCurrent(panel);
    }

    // -- SHOW ROOM DETAIL --
    public void btnDetailCurrentRestOnShowRoomDetail(RoomDetail roomDetail, JPanel back) {
        JPanel panel = new ConfirmationAndDetail(this, roomDetail.getCurrentRest(), 2, back);
        tools.setRoomsToTable(((ConfirmationAndDetail) panel).getTable(), roomDetail.getCurrentRest().getRooms());
        frame.changeCurrent(panel);
    }

    public void btnDetailReservedListOnShowRoomDetail(String socialNo, JPanel back) {
        RestForm rest = tools.getRestFromDatabase(socialNo);
        JPanel panel = new ConfirmationAndDetail(this, rest, 2, back);
        tools.setRoomsToTable(((ConfirmationAndDetail) panel).getTable(), rest.getRooms());
        frame.changeCurrent(panel);
    }

    // -- SHOW RESERVED AND CHECKED IN --
    public void btnSearchOnShowReservedAndCheckedIn(JPanel panel, int statusType, Date date, boolean isDateSelected) {
        ArrayList<RestForm> rests = tools.searchRestFromDatabase(statusType, date, isDateSelected);
        ((ShowReservedAndCheckedIn) panel).setRests(rests);
        tools.removeAllRow(((ShowReservedAndCheckedIn) panel).getTable());
        tools.setRestsToTable(((ShowReservedAndCheckedIn) panel).getTable(), rests);
    }

    public void btnDetailOnShowReservedAndCheckedIn(String socialNo, JPanel back) {
        RestForm rest = tools.getRestFromDatabase(socialNo);
        JPanel panel = new ConfirmationAndDetail(this, rest, 2, back);
        tools.setRoomsToTable(((ConfirmationAndDetail) panel).getTable(), rest.getRooms());
        frame.changeCurrent(panel);
    }

    // -- EDIT PROFILE --
    public void btnConfirmOnEditProfile(String password, String rePassword, String firstName, String lastName, int gender, String telephoneNo, String address) {
        if (password.isEmpty()) {
            tools.createMessageBox(frame, "Password is empty.");
        } else if (rePassword.isEmpty()) {
            tools.createMessageBox(frame, "Re Password is empty.");
        } else if (firstName.isEmpty()) {
            tools.createMessageBox(frame, "First Name is empty.");
        } else if (lastName.isEmpty()) {
            tools.createMessageBox(frame, "Last Name is empty.");
        } else if (telephoneNo.isEmpty()) {
            tools.createMessageBox(frame, "Telepohone No is empty.");
        } else if (address.isEmpty()) {
            tools.createMessageBox(frame, "Address is empty.");
        } else if (tools.isNotInRangeOf(password, 7, 13)) {
            tools.createMessageBox(frame, "Password need 7-13 letters.");
        } else if (tools.isNotTheSame(password, rePassword)) {
            tools.createMessageBox(frame, "Password and Re Password are not the same.");
        } else if (tools.isNotInRangeOf(firstName, 1, 20)) {
            tools.createMessageBox(frame, "First Name has to be least than or equal 20 letters.");
        } else if (tools.isNotInRangeOf(lastName, 1, 20)) {
            tools.createMessageBox(frame, "Last Name has to be least than or equal 20 letters.");
        } else if (tools.isNotANumber(telephoneNo)) {
            tools.createMessageBox(frame, "Telephone No need to be an only number.");
        } else if (tools.isNotNdigits(telephoneNo, 10)) {
            tools.createMessageBox(frame, "Telephone No need 10 letters.");
        } else {
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setGender(gender);
            user.setTelephoneNo(telephoneNo);
            user.setAddress(address);
            user.updateToDatabase();
            tools.createSuccessBox(frame, "Update User Detail Success");
            goToHome();
        }
    }
}
