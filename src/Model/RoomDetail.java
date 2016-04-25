package Model;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RoomDetail implements CanSetAllDetail{
    
    private Room room;
    private RestForm currentRest;
    private ArrayList<RestForm> reservedRests;

    public RoomDetail(Room room) {
        this.room = room;
        currentRest = null;
        reservedRests = new ArrayList<>();
    }

    @Override
    public void setAllDetailFromDatabase() {
        Database database = new Database("RoomDetail/setAllDetailToDatabase");
        String sql = "SELECT rest.restNo,status FROM rest,restDetail,room WHERE rest.restNo = restDetail.restNo AND restDetail.roomNo = room.roomNo AND room.roomNo = '" + room.getRoomNo() + "'";
        System.out.println(sql);
        database.connect(); 
        database.createStatement();
        ResultSet rs = database.executeQuery(sql);
        try {
            while(rs.next()){
                if(rs.getInt("status") == 0){
                    currentRest = new CheckInForm(rs.getInt("restNo"));
                    currentRest.setAllDetailFromDatabase();
                } else if (rs.getInt("status") == 1){
                    RestForm rf = new ReserveForm(rs.getInt("restNo"));
                    rf.setAllDetailFromDatabase();
                    reservedRests.add(rf);
                }
            }
        } catch (Exception e){
            System.out.println("ERROR : @RoomDetail/setAllDetailToDatabase > " + e);
        }
        database.disconnect();
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public RestForm getCurrentRest() {
        return currentRest;
    }

    public void setCurrentRest(RestForm currentRest) {
        this.currentRest = currentRest;
    }

    public ArrayList<RestForm> getReservedRests() {
        return reservedRests;
    }

    public void setReservedRests(ArrayList<RestForm> reservedRests) {
        this.reservedRests = reservedRests;
    }
    
    
    
}
