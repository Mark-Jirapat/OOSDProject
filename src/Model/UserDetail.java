package Model;

import java.sql.ResultSet;

public class UserDetail extends PersonDetail {
    
    private String userName;
    private String password;
    private boolean admin;

    public UserDetail(String socialNo, String firstName, String lastName, int gender, String telephoneNo, String address, String userName, String password) { //FOR NEW USER
        super(socialNo, firstName, lastName, gender, telephoneNo, address);
        this.userName = userName;
        this.password = password;
    }
    
    public UserDetail(String socialNo){ //NEED SET DETAIL
        super(socialNo);
    }

    @Override
    public void addToDatabase() {
        super.addToDatabase();
        Database database = new Database("UserDetail/addToDatabase");
        String sql = "INSERT INTO user VALUES ('"+ getSocialNo() + "','"+ userName + "','"+ password + "')";
        System.out.println(sql);
        database.connect(); 
        database.createStatement();
        database.execute(sql);
        database.disconnect();
    }
    
    @Override
    public void setAllDetailFromDatabase() {
        super.setAllDetailFromDatabase();
        Database database = new Database("UserDetail/setAllDetailToDatabase");
        String sql = "SELECT * FROM user WHERE socialNo = '" + getSocialNo() + "'";
        System.out.println(sql);
        database.connect(); 
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            if(rs.next()){
                userName = rs.getString("userName");
                password = rs.getString("password");
                admin = isAdminFromDatabase();
            }
        } catch (Exception e){
            System.out.println("ERROR : @UserDetail/setAllDetailToDatabase > " + e);
        }
        database.disconnect();
    }
    
    public boolean isAdminFromDatabase(){
        Database database = new Database("UserDetail/isAdminFromDatabase");
        String sql = "SELECT * FROM admin WHERE socialNo = '" + getSocialNo() + "'";
        System.out.println(sql);
        database.connect(); 
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            if(rs.next()){
                database.disconnect();
                return true;
            }
        } catch (Exception e){
            System.out.println("ERROR : @UserDetail/isAdminFromDatabase > " + e);
        }
        database.disconnect();
        return false;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean isAdmin) {
        this.admin = isAdmin;
    }   
    
}
