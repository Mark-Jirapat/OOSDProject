package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class RestForm implements CanAdd, CanSetAllDetail, CanDelete, CanUpdate {

    private int restNo;
    private CustomerDetail customer;
    private int amountOfPeople;
    private Date startDate;
    private Date endDate;
    private int status;
    private ArrayList<Room> rooms;

    public RestForm(int restNo) { // NEED SET DETAIL
        this.restNo = restNo;
        rooms = new ArrayList<Room>();
    }
    
    public RestForm(int restNo, int status) { // NEED SET DETAIL , FOR SUB CLASS
        this.restNo = restNo;
        this.status = status;
        rooms = new ArrayList<Room>();
    }

    public RestForm(CustomerDetail customer, int status) { //FOR NEW REST , FOR SUB CLASS
        this.customer = customer;
        this.status = status;
    }

    @Override
    public void addToDatabase() {
        Database database = new Database("RestForm/addToDatabase");
        String startDateInFormat = (startDate.getYear() + 1900) + "-" + (startDate.getMonth() + 1) + "-" + startDate.getDate();
        String endDateInFormat = (endDate.getYear() + 1900) + "-" + (endDate.getMonth() + 1) + "-" + endDate.getDate();
        String sql = "INSERT INTO rest VALUES (NULL,'" + getCustomer().getSocialNo() + "','" + amountOfPeople + "','" + startDateInFormat + "','" + endDateInFormat + "','" + status + "')";
        System.out.println(sql);
        database.connect();
        database.createStatement();
        database.execute(sql);
        database.disconnect();
        setRestNoFromDataBase();
        addRoomListToDatabase();
    }

    public void setRestNoFromDataBase() {
        Database database = new Database("RestForm/setRestNoFromDataBase");
        String sql = "SELECT restNo FROM rest WHERE socialNo = '" + getCustomer().getSocialNo() + "'";
        System.out.println(sql);
        database.connect();
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            if (rs.next()) {
                restNo = rs.getInt("restNo");
            }
        } catch (Exception e) {
            System.out.println("ERROR : @RestForm/setRestNoFromDataBase > " + e);
        }
        database.disconnect();
    }

    public void addRoomListToDatabase() {
        Database database = new Database("RestForm/addRoomListToDatabase");
        for (Room r : rooms) {
            String sql = "INSERT INTO restDetail VALUES ('" + restNo + "','" + r.getRoomNo() + "')";
            System.out.println(sql);
            database.connect();
            database.createStatement();
            database.execute(sql);
            database.disconnect();
        }
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

    @Override
    public void deleteFromDatabase() {
        Database database = new Database("RestForm/deleteFromDatabase");
        database.connect();
        database.createStatement();
        String sql = "DELETE FROM rest WHERE restNo = '" + restNo + "'";
        System.out.println(sql);
        database.execute(sql);
        sql = "DELETE FROM restDetail WHERE restNo = '" + restNo + "'";
        System.out.println(sql);
        database.execute(sql);
        database.disconnect();
    }

    @Override
    public void updateToDatabase() {
        Database database = new Database("RestFormDetail/updateToDatabase");
        String sql = "UPDATE rest SET status = '" + status + "' WHERE restNo = '" + restNo + "'";
        System.out.println(sql);
        database.connect();
        database.createStatement();
        database.execute(sql);
        database.disconnect();
    }

    public int getExtraPrice() {
        int extraPrice = 0;
        int extraDay = getExtraDay();
        if (extraDay > 0) {
            for (Room r : rooms) {
                extraPrice += r.getRoomType().getPrice();
            }
            extraPrice *= extraDay;
        }
        return extraPrice;
    }

    public int getExtraDay() {
        Date currentDate = new Tools().getCurrentDate();
        if(endDate.equals(currentDate) || endDate.after(currentDate)){
            return 0;
        }
        Calendar calCurrentDate = Calendar.getInstance();
        calCurrentDate.setTime(currentDate);
        Calendar calEndDate = Calendar.getInstance();
        calEndDate.setTime(endDate);
        int extraDay = 0;
        while (calEndDate.before(calCurrentDate)) {
            calEndDate.add(Calendar.DAY_OF_MONTH, 1);
            extraDay++;
        }
        return extraDay;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Room r : rooms) {
            totalPrice += r.getRoomType().getPrice();
        }
        totalPrice *= getTotalDay();
        return totalPrice;
    }

    public int getTotalBed() {
        int totalBed = 0;
        for (Room r : rooms) {
            totalBed += r.getRoomType().getAmountOfBed();
        }
        return totalBed;
    }

    public int getTotalRoom() {
        return rooms.size();
    }

    public int getTotalDay() {
        Calendar calStartDate = Calendar.getInstance();
        calStartDate.setTime(startDate);
        Calendar calEndDate = Calendar.getInstance();
        calEndDate.setTime(endDate);
        int totalDay = 1;
        while (calStartDate.before(calEndDate)) {
            calStartDate.add(Calendar.DAY_OF_MONTH, 1);
            totalDay++;
        }
        return totalDay;
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
