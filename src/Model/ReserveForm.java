package Model;

public class ReserveForm extends RestForm{

    public ReserveForm(int restNo) {
        super(restNo, 1);
    }

    public ReserveForm(CustomerDetail customer) {
        super(customer, 1);
    }
    
}
