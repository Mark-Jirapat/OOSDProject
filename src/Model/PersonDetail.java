package Model;

import java.sql.ResultSet;

public class PersonDetail implements CanAdd, CanSetAllDetail {
    
    private String socialNo;
    private String firstName;
    private String lastName;
    private int gender;
    private String telephoneNo;
    private String address;

    public PersonDetail(String socialNo, String firstName, String lastName, int gender, String telephoneNo, String address) {
        this.socialNo = socialNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.telephoneNo = telephoneNo;
        this.address = address;
    }

    public PersonDetail(String socialNo) {
        this.socialNo = socialNo;
    }

    @Override
    public void addToDatabase() {
        Database database = new Database("PersonDetail/addToDatabase");
        String sql = "INSERT INTO person VALUES ('"+ socialNo + "','"+ firstName + "','"+ lastName + "','"+ gender + "','"+ telephoneNo + "','"+ address + "')";
        System.out.println(sql);
        database.connect(); 
        database.createStatement();
        database.execute(sql);
        database.disconnect();
    }
    
    @Override
    public void setAllDetailFromDatabase() {
        Database database = new Database("PersonDetail/setAllDetailFromDatabase");
        String sql = "SELECT * FROM person WHERE socialNo = '" + socialNo + "'";
        System.out.println(sql);
        database.connect(); 
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            if(rs.next()){
                socialNo = rs.getString("socialNo");
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                gender = rs.getInt("gender");
                telephoneNo = rs.getString("telephoneNo");
                address = rs.getString("address");
            }
        } catch (Exception e){
            System.out.println("ERROR : @PersonDetail/setAllDetailFromDatabase > " + e);
        }
        database.disconnect();
    }

    public String getSocialNo() {
        return socialNo;
    }

    public void setSocialNo(String socialNo) {
        this.socialNo = socialNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getGenderToString(){
        return ((gender == 0)?"Male":"Female") ;
    }
    
}
