package Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.freixas.jcalendar.JCalendar;

public class Tools {

    public void createMessageBox(JFrame frame, String text) {
        System.out.println("MessageBox : " + text);
        JOptionPane.showMessageDialog(frame, text, "Message Box", JOptionPane.WARNING_MESSAGE);
    }

    public void createSuccessBox(JFrame frame, String text) {
        System.out.println("MessageBox : " + text);
        JOptionPane.showMessageDialog(frame, text, "Message Box", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean isNotANumber(String text) {
        for (int i = 0; i < text.length(); i++) {
            try {
                Integer.parseInt(text.charAt(i) + "");
            } catch (Exception e) {
                return true;
            }
        }
        return false;
    }

    public boolean isNotNdigits(String text, int digit) {
        return (text.length() != digit);
    }

    public boolean isNotInRangeOf(String text, int digit1, int digit2) {
        return (text.length() < digit1 || text.length() > digit2);
    }

    public boolean isNotTheSame(String text1, String text2) {
        return !(text1.equals(text2));
    }

    public boolean isHasUserNameInTheSystem(String text) {
        Database database = new Database("Tools/isUserNameHasInTheSystem");
        String sql = "SELECT * FROM person WHERE socialNo = '" + text + "'";
        System.out.println(sql);
        database.connect();
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            if (rs.next()) {
                database.disconnect();
                return true;
            }
        } catch (Exception e) {
            System.out.println("ERROR : @Tools/isUserNameHasInTheSystem > " + e);
        }
        database.disconnect();
        return false;
    }

    public boolean isHasSocialNoInTheSystem(String text) {
        Database database = new Database("Tools/isHasSocialNoInTheSystem");
        String sql = "SELECT * FROM user WHERE userName = '" + text + "'";
        System.out.println(sql);
        database.connect();
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            if (rs.next()) {
                database.disconnect();
                return true;
            }
        } catch (Exception e) {
            System.out.println("ERROR : @Tools/isHasSocialNoInTheSystem > " + e);
        }
        database.disconnect();
        return false;
    }

    public UserDetail getUserFromDatabase(String userName, String password) {
        UserDetail user = null;
        Database database = new Database("Tools/getUserFromDatabase");
        String sql = "SELECT socialNo FROM user WHERE userName = '" + userName + "' AND password = '" + password + "'";
        System.out.println(sql);
        database.connect();
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            if (rs.next()) {
                user = new UserDetail(rs.getString("socialNo"));
                user.setAllDetailFromDatabase();
            }
        } catch (Exception e) {
            System.out.println("ERROR : @Tools/getUserFromDatabase > " + e);
        }
        database.disconnect();
        return user;
    }

    public ArrayList<CustomerDetail> getAllCustomerFromDatabase() {
        ArrayList<CustomerDetail> customers = null;
        Database database = new Database("Tools/getAllCustomerFromDatabase");
        String sql = "SELECT socialNo FROM person WHERE socialNo NOT IN (SELECT socialNo FROM user)";
        System.out.println(sql);
        database.connect();
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            customers = new ArrayList<>();
            while (rs.next()) {
                CustomerDetail customer = new CustomerDetail(rs.getString("socialNo"));
                customer.setAllDetailFromDatabase();
                customers.add(customer);
            }
        } catch (Exception e) {
            System.out.println("ERROR : @Tools/getAllCustomerFromDatabase > " + e);
        }
        database.disconnect();
        return customers;
    }

    public void setCustomersToTable(JTable table, ArrayList<CustomerDetail> customers) {
        if (customers == null) {
            return;
        }
        int row = 0;
        for (CustomerDetail c : customers) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{null, null, null, null});
            table.getModel().setValueAt(c.getSocialNo(), row, 0);
            table.getModel().setValueAt(c.getFirstName(), row, 1);
            table.getModel().setValueAt(c.getLastName(), row, 2);
            table.getModel().setValueAt(c.getStatusToString(), row, 3);
            row++;
        }
    }

    public ArrayList<CustomerDetail> searchCustomerFromDatabase(String text, int textType, int statusType) {
        ArrayList<CustomerDetail> customers = null;
        Database database = new Database("Tools/searchCustomerFromDatabase");
        String type;
        int status = statusType - 2;
        switch (textType) {
            case 0:
                type = "socialNo";
                break;
            case 1:
                type = "firstName";
                break;
            case 2:
                type = "lastName";
                break;
            default:
                return null;
        }
        String sql;
        if (text.isEmpty()) {
            if (status == -2) {
                return getAllCustomerFromDatabase();
            } else if (status == -1) {
                sql = "SELECT socialNo FROM person WHERE socialNo NOT IN (SELECT socialNo FROM user) AND socialNo NOT IN (SELECT socialNo FROM rest)";
            } else {
                sql = "SELECT socialNo FROM person WHERE socialNo NOT IN (SELECT socialNo FROM user) AND socialNo IN (SELECT socialNo FROM rest WHERE status = '" + status + "')";
            }
        } else {
            if (status == -2) {
                sql = "SELECT socialNo FROM person WHERE socialNo NOT IN (SELECT socialNo FROM user) AND " + type + " LIKE '" + text + "%'";
            } else if (status == -1) {
                sql = "SELECT socialNo FROM person WHERE socialNo NOT IN (SELECT socialNo FROM user) AND socialNo NOT IN (SELECT socialNo FROM rest) AND " + type + " LIKE '" + text + "%'";
            } else {
                sql = "SELECT socialNo FROM person WHERE socialNo NOT IN (SELECT socialNo FROM user) AND socialNo IN (SELECT socialNo FROM rest WHERE status = '" + status + "') AND " + type + " LIKE '" + text + "%'";
            }
        }
        System.out.println(sql);
        database.connect();
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            customers = new ArrayList<>();
            while (rs.next()) {
                CustomerDetail customer = new CustomerDetail(rs.getString("socialNo"));
                customer.setAllDetailFromDatabase();
                customers.add(customer);
            }
        } catch (Exception e) {
            System.out.println("ERROR : @Tools/searchCustomerFromDatabase > " + e);
        }
        database.disconnect();
        return customers;
    }

    public void removeAllRow(JTable table) {
        DefaultTableModel dm = (DefaultTableModel) table.getModel();
        int row = dm.getRowCount();
        for (int i = row - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }

    public CustomerDetail getCustomerFromCustomerList(String socialNo, ArrayList<CustomerDetail> customers) {
        for (CustomerDetail c : customers) {
            if (c.getSocialNo().equals(socialNo)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Room> getAllRoomFromDatabase() {
        ArrayList<Room> rooms = null;
        Database database = new Database("Tools/getAllRoomFromDatabase");
        String sql = "SELECT roomNo FROM room";
        System.out.println(sql);
        database.connect();
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            rooms = new ArrayList<>();
            while (rs.next()) {
                Room room = new Room(rs.getInt("roomNo"));
                room.setAllDetailFromDatabase();
                rooms.add(room);
            }
        } catch (Exception e) {
            System.out.println("ERROR : @Tools/getAllRoomFromDatabase > " + e);
        }
        database.disconnect();
        return rooms;
    }

    public void setRoomsToTable(JTable table, ArrayList<Room> rooms) {
        if (rooms == null) {
            return;
        }
        int row = 0;
        for (Room r : rooms) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{null, null, null, 0, null, false});
            table.getModel().setValueAt(r.getRoomNo(), row, 0);
            table.getModel().setValueAt(r.getRoomType().getRoomTypeName(), row, 1);
            table.getModel().setValueAt(r.getFloorNo(), row, 2);
            table.getModel().setValueAt(r.getRoomType().getAmountOfBed(), row, 3);
            table.getModel().setValueAt(r.getRoomType().getPrice(), row, 4);
            row++;
        }
    }

    public ArrayList<Room> searchRoomFromDatabase(String roomNo, int floorNo, String roomTypeName) {
        ArrayList<Room> rooms = null;
        Database database = new Database("Tools/searchRoomFromDatabase");
        String sql;
        if (roomNo.isEmpty()) {
            if (floorNo == 0) {
                if (roomTypeName.equals("-")) {
                    return getAllRoomFromDatabase();
                } else {
                    sql = "SELECT room.roomNo FROM room,roomType WHERE room.roomTypeNo = roomType.roomTypeNo AND roomTypeName = '" + roomTypeName + "'";
                }
            } else {
                if (roomTypeName.equals("-")) {
                    sql = "SELECT roomNo FROM room WHERE floorNo = '" + floorNo + "'";
                } else {
                    sql = "SELECT room.roomNo FROM room,roomType WHERE room.roomTypeNo = roomType.roomTypeNo AND roomTypeName = '" + roomTypeName + "' AND floorNo = '" + floorNo + "'";
                }
            }
        } else {
            if (floorNo == 0) {
                if (roomTypeName.equals("-")) {
                    sql = "SELECT roomNo FROM room WHERE roomNo LIKE '" + roomNo + "%'";
                } else {
                    sql = "SELECT room.roomNo FROM room,roomType WHERE room.roomTypeNo = roomType.roomTypeNo AND roomTypeName = '" + roomTypeName + "' AND room.roomNo LIKE '" + roomNo + "%'";
                }
            } else {
                if (roomTypeName.equals("-")) {
                    sql = "SELECT roomNo FROM room WHERE floorNo = '" + floorNo + "' AND roomNo LIKE '" + roomNo + "%'";
                } else {
                    sql = "SELECT room.roomNo FROM room,roomType WHERE room.roomTypeNo = roomType.roomTypeNo AND roomTypeName = '" + roomTypeName + "' AND room.floorNo = '" + floorNo + "' AND room.roomNo LIKE '" + roomNo + "%'";
                }
            }
        }
        System.out.println(sql);
        database.connect();
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            rooms = new ArrayList<>();
            while (rs.next()) {
                Room room = new Room(rs.getInt("roomNo"));
                room.setAllDetailFromDatabase();
                rooms.add(room);
            }
        } catch (Exception e) {
            System.out.println("ERROR : @Tools/searchRoomFromDatabase > " + e);
        }
        database.disconnect();
        return rooms;
    }

    public ArrayList<RoomType> getAllRoomTypeFromDatabase() {
        ArrayList<RoomType> roomTypes = null;
        Database database = new Database("Tools/getAllRoomTypeFromDatabase");
        String sql = "SELECT roomTypeNo FROM roomType";
        System.out.println(sql);
        database.connect();
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            roomTypes = new ArrayList<>();
            while (rs.next()) {
                RoomType roomType = new RoomType(rs.getInt("roomTypeNo"));
                roomType.setAllDetailFromDatabase();
                roomTypes.add(roomType);
            }
        } catch (Exception e) {
            System.out.println("ERROR : @Tools/getAllRoomTypeFromDatabase > " + e);
        }
        database.disconnect();
        return roomTypes;
    }

    public void setRoomTypesToComboBox(JComboBox comboBox, ArrayList<RoomType> roomTypes) {
        if (roomTypes == null) {
            return;
        }
        for (RoomType r : roomTypes) {
            comboBox.addItem(r.getRoomTypeName());
        }
    }

    public ArrayList<RestForm> getAllRestFromDatabase() {
        ArrayList<RestForm> rests = null;
        Database database = new Database("Tools/getAllRestFromDatabase");
        String sql = "SELECT restNo FROM rest";
        System.out.println(sql);
        database.connect();
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            rests = new ArrayList<>();
            while (rs.next()) {
                RestForm rest = new RestForm(rs.getInt("restNo"));
                rest.setAllDetailFromDatabase();
                rests.add(rest);
            }
        } catch (Exception e) {
            System.out.println("ERROR : @Tools/getAllRestFromDatabase > " + e);
        }
        database.disconnect();
        return rests;
    }

    public void setRestsToTable(JTable table, ArrayList<RestForm> rests) {
        if (rests == null) {
            return;
        }
        int row = 0;
        for (RestForm r : rests) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{null, null, null, null, null});
            table.getModel().setValueAt(r.getCustomer().getSocialNo(), row, 0);
            table.getModel().setValueAt(r.getCustomer().getFirstName(), row, 1);
            table.getModel().setValueAt(r.getCustomer().getLastName(), row, 2);
            table.getModel().setValueAt(r.getStartDateToString(), row, 3);
            table.getModel().setValueAt(r.getEndDateToString(), row, 4);
            table.getModel().setValueAt(r.getStatusToString(), row, 5);
            row++;
        }
    }

    public ArrayList<RestForm> searchRestFromDatabase(int statusType, Date date, boolean isDateSelected) {
        ArrayList<RestForm> rests = null;
        Database database = new Database("Tools/searchRestFromDatabase");
        int status = statusType - 1;
        String dateInFormat = (date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-" + date.getDate();
        String sql;
        if (!isDateSelected) {
            if (status == -1) {
                return getAllRestFromDatabase();
            } else {
                sql = "SELECT restNo FROM rest WHERE status = '" + status + "'";
            }
        } else {
            if (status == -1) {
                sql = "SELECT restNo FROM rest WHERE '" + dateInFormat + "' BETWEEN startDate AND endDate";
            } else {
                sql = "SELECT restNo FROM rest WHERE status = '" + status + "' AND '" + dateInFormat + "' BETWEEN startDate AND endDate";
            }
        }
        System.out.println(sql);
        database.connect();
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            rests = new ArrayList<>();
            while (rs.next()) {
                RestForm rest = new RestForm(rs.getInt("restNo"));
                rest.setAllDetailFromDatabase();
                rests.add(rest);
            }
        } catch (Exception e) {
            System.out.println("ERROR : @Tools/searchRestFromDatabase > " + e);
        }
        database.disconnect();
        return rests;
    }

    public Room getRoomFromRoomList(int roomNo, ArrayList<Room> rooms) {
        for (Room r : rooms) {
            if (r.getRoomNo() == roomNo) {
                return r;
            }
        }
        return null;
    }

    public void setReservedListToTable(JTable table, ArrayList<RestForm> reservedRests) {
        if (reservedRests == null || reservedRests.isEmpty()) {
            return;
        }
        int row = 0;
        for (RestForm r : reservedRests) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{null, null, null, null, null});
            table.getModel().setValueAt(r.getCustomer().getSocialNo(), row, 0);
            table.getModel().setValueAt(r.getCustomer().getFirstName(), row, 1);
            table.getModel().setValueAt(r.getCustomer().getLastName(), row, 2);
            table.getModel().setValueAt(r.getStartDateToString(), row, 3);
            table.getModel().setValueAt(r.getEndDateToString(), row, 4);
            row++;
        }
    }

    public Date getCurrentDate() {
        Date date = new JCalendar().getDate();
        Date currentDate = new Date(date.getYear(), date.getMonth(), date.getDate());
        return currentDate;
    }

    public ArrayList<Room> getAvialableRoomFromDatabase(Date startDate, Date endDate) {
        ArrayList<Room> rooms = null;
        String startDateInFormat = (startDate.getYear() + 1900) + "-" + (startDate.getMonth() + 1) + "-" + startDate.getDate();
        String endDateInFormat = (endDate.getYear() + 1900) + "-" + (endDate.getMonth() + 1) + "-" + endDate.getDate();
        Database database = new Database("Tools/getAvialableRoomFromDatabase");
        String condition = "(SELECT restNo FROM rest WHERE startDate BETWEEN '" + startDateInFormat + "' AND '" + endDateInFormat + "' OR '" + startDateInFormat + "' BETWEEN startDate and endDate OR '" + endDateInFormat + "' BETWEEN startDate AND endDate)";
        String condition2 = "(SELECT roomNo FROM restDetail WHERE restNo IN " + condition + ")";
        String sql = "SELECT roomNo FROM room WHERE roomNo NOT IN " + condition2;
        System.out.println(sql);
        database.connect();
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            rooms = new ArrayList<>();
            while (rs.next()) {
                Room room = new Room(rs.getInt("roomNo"));
                room.setAllDetailFromDatabase();
                System.out.println(room.getRoomNo());
                rooms.add(room);
            }
        } catch (Exception e) {
            System.out.println("ERROR : @Tools/getAvialableRoomFromDatabase > " + e);
        }
        database.disconnect();
        return rooms;
    }

    public ArrayList<Room> getRoomListFromRoomList(ArrayList<Room> rooms, ArrayList<Integer> selectedRoomNo) {
        ArrayList<Room> selectedRooms = new ArrayList<>();
        for (Integer roomNo : selectedRoomNo) {
            for (Room r : rooms) {
                if (r.getRoomNo() == roomNo) {
                    selectedRooms.add(r);
                }
            }
        }
        if (selectedRooms.isEmpty()) {
            return null;
        }
        return selectedRooms;
    }

    public RestForm getRestFromDatabase(String socialNo) {
        RestForm rest = null;
        Database database = new Database("Tools/getRestFromDatabase");
        String sql = "SELECT restNo FROM rest WHERE socialNo = '" + socialNo + "'";
        System.out.println(sql);
        database.connect();
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            if (rs.next()) {
                rest = new RestForm(rs.getInt("restNo"));
                rest.setAllDetailFromDatabase();
            }
        } catch (Exception e) {
            System.out.println("ERROR : @Tools/getRestFromDatabase > " + e);
        }
        database.disconnect();
        return rest;
    }

    public void removeExpiredReserveFromDatebase(Date currentDate) {
        ArrayList<Integer> restNoList = null;
        String currentDateInFormat = (currentDate.getYear() + 1900) + "-" + (currentDate.getMonth() + 1) + "-" + currentDate.getDate();
        Database database = new Database("Tools/removeExpiredReserveFromDatebase");
        String sql = "SELECT restNo FROM rest WHERE startDate < '" + currentDateInFormat + "' AND status = '1'";
        System.out.println(sql);
        database.connect();
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            restNoList = new ArrayList<>();
            while (rs.next()) {
                restNoList.add(rs.getInt("restNo"));
            }
        } catch (Exception e) {
            System.out.println("ERROR : @Tools/removeExpiredReserveFromDatebase > " + e);
        }
        for (Integer restNo : restNoList) {
            sql = "DELETE FROM rest WHERE restNo = '" + restNo + "'";
            System.out.println(sql);
            database.execute(sql);
        }
        for (Integer restNo : restNoList) {
            sql = "DELETE FROM restDetail WHERE restNo = '" + restNo + "'";
            System.out.println(sql);
            database.execute(sql);
        }
        database.disconnect();
        System.out.println("*** " + restNoList.size() + " Expired Reserved Detail ***");
    }

}
