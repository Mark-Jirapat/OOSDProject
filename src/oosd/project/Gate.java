package oosd.project;

public class Gate implements Controller{
    
    private RegisterForm registerForm;
    
    public void userRegister(){
        registerForm = new UserRegisterForm();
        //..
    }
    
    public void logIn(){
        User user = new User();
        //..
    }
}
