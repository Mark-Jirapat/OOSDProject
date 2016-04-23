package Model;

import java.sql.ResultSet;

public class CustomerDetail extends PersonDetail{
    
    private int status = -1;

    public CustomerDetail(String socialNo, String firstName, String lastName, int gender, String telephonNo, String address) { //FOR NEW CUSTOMER
        super(socialNo, firstName, lastName, gender, telephonNo, address);
    }
    
    public CustomerDetail(String socialNo){ //NEED SET DETAIL
        super(socialNo);
    }
    
    @Override
    public void setAllDetailFromDatabase() {
        super.setAllDetailFromDatabase();
        Database database = new Database("CustomerDetail/setAllDetailFromDatabase");
        String sql = "SELECT status FROM rest WHERE socialNo = '" + getSocialNo() + "'";
        System.out.println(sql);
        database.connect(); 
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            if(rs.next()){
                status = rs.getInt("status");
            } 
        } catch (Exception e){
            System.out.println("ERROR : @CustomerDetail/setAllDetailFromDatabase > " + e);
        }
        database.disconnect();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getStatusToString(){
        switch(status){
            case 0 : return "Checking In";
            case 1 : return "Reserved";
            default : return "-";
        }
    }
    
}
