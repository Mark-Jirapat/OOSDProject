package Model;

import java.sql.ResultSet;

public class UserDetail extends PersonDetail implements CanUpdate {
    
    private String userName;
    private String password;

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
            }
        } catch (Exception e){
            System.out.println("ERROR : @UserDetail/setAllDetailToDatabase > " + e);
        }
        database.disconnect();
    }
    
    @Override
    public void updateToDatabase() {
        Database database = new Database("UserDetail/updateToDatabase");
        String sql = "UPDATE user SET password = '"+ password + "' WHERE socialNo = '" + getSocialNo() + "'";
        System.out.println(sql);
        database.connect(); 
        database.createStatement();
        database.execute(sql);
        sql = "UPDATE person SET firstName = '"+ getFirstName() + "', lastName = '"+ getLastName() + "', gender = '"+ getGender() + "', telephoneNo = '"+ getTelephoneNo() + "', address = '"+ getAddress() + "' WHERE socialNo = '" + getSocialNo() + "'";
        System.out.println(sql);
        database.execute(sql);
        database.disconnect();
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

}
