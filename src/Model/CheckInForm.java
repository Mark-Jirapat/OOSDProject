package Model;

public class CheckInForm extends RestForm {

    public CheckInForm(int restNo) {
        super(restNo, 0);
    }

    public CheckInForm(CustomerDetail customer) {
        super(customer, 0);
    }

}
