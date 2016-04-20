package Model;

public class CustomerDetail extends PersonDetail{

    public CustomerDetail(int socialNo, String firstName, String lastName, int gender, String telephonNo, String address) { //FOR NEW CUSTOMER
        super(socialNo, firstName, lastName, gender, telephonNo, address);
    }
    
    public CustomerDetail(int socialNo){ //NEED SET DETAIL
        super(socialNo);
    }
    
}
