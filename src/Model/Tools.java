package Model;

import java.sql.ResultSet;
import javax.swing.*;

public class Tools {
    
    public void createMessageBox(JFrame frame, String text){
        JOptionPane.showMessageDialog(frame, text, "Message Box",JOptionPane.WARNING_MESSAGE);
        System.out.println(text);
    }
    
    public void createSuccessBox(JFrame frame, String text){
        JOptionPane.showMessageDialog(frame, text, "Message Box",JOptionPane.INFORMATION_MESSAGE);
        System.out.println(text);
    }
    
    public boolean isNotANumber(String text){
        try {
            Integer.valueOf(text);
            return false;
        } catch (Exception e) {
            return true;
        }
    }
    
    public boolean isNotNdigits(String text, int digit) {
        return (text.length() != digit);
    }
    
    public boolean isNotEnoughdigits(String text, int digit) {
        return (text.length() < digit);
    }
    
    public boolean isNotTheSame(String text1, String text2){
        return !(text1.equals(text2));
    }
    
    public boolean isHasUserNameInTheSystem(String text){
        Database database = new Database("Tools/isUserNameHasInTheSystem");
        String sql = "SELECT * FROM person WHERE socialNo = '" + text + "'";
        System.out.println(sql);
        ResultSet rs = database.doExecuteQuery(sql);
        try {
            if(rs.next()){
                return true;
            }
        } catch (Exception e){
            System.out.println("ERROR : @Tools/isUserNameHasInTheSystem > " + e);
        }
        return false;
    }
    
    public boolean isHasSocialNoInTheSystem(String text){
        Database database = new Database("Tools/isHasSocialNoInTheSystem");
        String sql = "SELECT * FROM user WHERE userName = '" + text + "'";
        System.out.println(sql);
        ResultSet rs = database.doExecuteQuery(sql);
        try {
            if(rs.next()){
                return true;
            }
        } catch (Exception e){
            System.out.println("ERROR : @Tools/isHasSocialNoInTheSystem > " + e);
        }
        return false;
    }
    
    public UserDetail getUserFromDatabase(String userName, String password){
        UserDetail user = null;
        Database database = new Database("Tools/getUserFromDatabase");
        String sql = "SELECT socialNo FROM user WHERE userName = '" + userName + "' AND '" + password + "'";
        System.out.println(sql);
        ResultSet rs = database.doExecuteQuery(sql);
        try {
            if(rs.next()){
                user = new UserDetail(rs.getInt("socialNo"));
                user.setAllDetailFromDatabase();
            }
        } catch (Exception e){
            System.out.println("ERROR : @Tools/getUserFromDatabase > " + e);
        }
        return user;
    }
    
}
