package oosd.project;

public class User extends People implements UserController {
   
    private String id, password;
    private boolean online;
    private People customer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public void logOut() {
        //..
    }

    public void editProfile() {
        //..
    }

    public void customerRegister() {
        customer = new Customer();
        RegisterForm registerForm = new CustomerRegisterForm();
        //..
    }

    public void reserve() {
        customer = new Customer();
        RestForm restForm = new ReserveForm();
        //..
    }

    public void cancelReserve() {
        customer = new Customer();
        //..
    }

    public void checkIn() {
        customer = new Customer();
        RestForm restForm = new CheckInForm();
        //..
    }
    
    public void checkOut() {
        customer = new Customer();
        //..
    }

    
}
