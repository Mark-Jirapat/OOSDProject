package Model;

import java.sql.ResultSet;

public class PersonDetail implements CanAdd, CanSetAllDetail {
    
    private int socialNo;
    private String firstName;
    private String lastName;
    private int gender;
    private String telephoneNo;
    private String address;

    public PersonDetail(int socialNo, String firstName, String lastName, int gender, String telephoneNo, String address) {
        this.socialNo = socialNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.telephoneNo = telephoneNo;
        this.address = address;
    }

    public PersonDetail(int socialNo) {
        this.socialNo = socialNo;
    }

    @Override
    public void addToDatabase() {
        Database database = new Database("PersonDetail/addToDatabase");
        String sql = "INSERT TO person VALUES ('"+ socialNo + "'"+ firstName + "'"+ lastName + "'"+ gender + "'"+ telephoneNo + "'"+ address + "')";
        System.out.println(sql);
        database.doExecute(sql);
    }
    
    public void setAllDetailFromDatabase() {
        Database database = new Database("PersonDetail/setAllDetailToDatabase");
        String sql = "SELECT * FROM person WHERE socialNo = '" + socialNo + "'";
        System.out.println(sql);
        ResultSet rs = database.doExecuteQuery(sql);
        try {
            if(rs.next()){
                socialNo = rs.getInt("socialNo");
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                gender = rs.getInt("socialNo");
                telephoneNo = rs.getString("telephoneNo");
                address = rs.getString("address");
            }
        } catch (Exception e){
            System.out.println("ERROR : @PersonDetail/setAllDetailToDatabase > " + e);
        }
    }

    public int getSocialNo() {
        return socialNo;
    }

    public void setSocialNo(int socialNo) {
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

    public String getTelephonNo() {
        return telephoneNo;
    }

    public void setTelephonNo(String telephonNo) {
        this.telephoneNo = telephonNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}
