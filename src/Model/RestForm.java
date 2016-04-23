package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class RestForm implements CanAdd, CanSetAllDetail {

    private int restNo;
    private CustomerDetail customer;
    private int amountOfPeople;
    private Date startDate;
    private Date endDate;
    private int status;
    private ArrayList<Room> rooms;

    public RestForm(int restNo) { //NEED SET DETAIL
        this.restNo = restNo;
        rooms = new ArrayList<Room>();
    }

    public RestForm(int restNo, CustomerDetail customer, int amountOfPeople, Date startDate, Date endDate, int status, ArrayList<Room> rooms) { //FOR NEW REST
        this.restNo = restNo;
        this.customer = customer;
        this.amountOfPeople = amountOfPeople;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.rooms = rooms;
    }

    @Override
    public void addToDatabase() {
        Database database = new Database("RestForm/addToDatabase");
        String sql = "INSERT INTO rest VALUES (NULL" + getCustomer().getSocialNo() + "'" + amountOfPeople + "'" + startDate + "'" + endDate + "'" + status + "')";
        System.out.println(sql);
        database.connect();
        database.createStatement();
        database.execute(sql);
        sql = "SELECT restNo FORM rest WHERE customerNo = '" + getCustomer().getSocialNo() + "'";
        ResultSet rs = database.executeQuery(sql);
        try {
            if (rs.next()) {
                restNo = rs.getInt("restNo");
            }
        } catch (Exception e) {
            System.out.println("ERROR : @RestForm/addToDatabase > " + e);
        }
        for (Room r : rooms) {
            sql = "INSERT INTO restDetail VALUES ('" + restNo + "','" + r.getRoomNo() + "')";
            System.out.println(sql);
            database.execute(sql);
        }
        database.disconnect();
    }

    @Override
    public void setAllDetailFromDatabase() {
        Database database = new Database("RestForm/setAllDetailToDatabase");
        String sql = "SELECT * FROM rest,restDetail WHERE rest.restNo = restDetail.restNo AND rest.restNo = '" + restNo + "'";
        System.out.println(sql);
        database.connect();
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        String socialNo = "";
        try {
            while (rs.next()) {
                socialNo = rs.getString("socialNo");
                restNo = rs.getInt("restNo");
                amountOfPeople = rs.getInt("amountOfPeople");
                startDate = rs.getDate("startDate");
                endDate = rs.getDate("endDate");
                status = rs.getInt("status");
                Room r = new Room(rs.getInt("roomNo"));
                r.setAllDetailFromDatabase();
                rooms.add(r);

            }
            customer = new CustomerDetail(socialNo);
            customer.setAllDetailFromDatabase();
        } catch (Exception e) {
            System.out.println("ERROR : @RestForm/setAllDetailToDatabase > " + e);
        }
        database.disconnect();
    }

    public int getTotalPrice() { //INCOMPLETE
        int totalPrice = 0;
        int amountOfDay = 0; //GET amount of day SOME HOW ..
        for (Room r : rooms) {
            totalPrice += r.getRoomType().getPrice();
        }
        totalPrice *= amountOfDay;
        return totalPrice;
    }

    public int getTotalBed() {
        int totalBed = 0;
        for (Room r : rooms) {
            totalBed += r.getRoomType().getAmountOfBed();
        }
        return totalBed;
    }

    public int getRestNo() {
        return restNo;
    }

    public void setRestNo(int restNo) {
        this.restNo = restNo;
    }

    public CustomerDetail getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDetail customer) {
        this.customer = customer;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public String getStatusToString() {
        return ((status == 0) ? "Checked In" : "Reserved");
    }

    public String convertDateToString(Date date) {
        String month = "";
        switch (date.getMonth()) {
            case 0:
                month = "January";
                break;
            case 1:
                month = "February";
                break;
            case 2:
                month = "March";
                break;
            case 3:
                month = "April";
                break;
            case 4:
                month = "May";
                break;
            case 5:
                month = "June";
                break;
            case 6:
                month = "July";
                break;
            case 7:
                month = "August";
                break;
            case 8:
                month = "September";
                break;
            case 9:
                month = "October";
                break;
            case 10:
                month = "November";
                break;
            case 11:
                month = "December";
                break;
            default:
                break;
        }
        return date.getDate() + " " + month + " " + (date.getYear() + 1900);
    }

    public String getStartDateToString() {
        return convertDateToString(startDate);
    }

    public String getEndDateToString() {
        return convertDateToString(endDate);
    }
}
