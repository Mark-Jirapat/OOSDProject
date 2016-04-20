package Model;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RoomDetail implements CanSetAllDetail{
    
    private Room room;
    private RestForm currentRest;
    private ArrayList<RestForm> reservedRests;

    public RoomDetail(Room room) {
        this.room = room;
    }

    @Override
    public void setAllDetailFromDatabase() {
        Database database = new Database("RoomDetail/setAllDetailToDatabase");
        String sql = "SELECT restNo,status FROM rest WHERE rest.restNo = restDetail.restNo AND restDetail.roomNo = room.roomNo AND room.roomNo = '" + room.getRoomNo() + "'";
        System.out.println(sql);
        ResultSet rs = database.doExecuteQuery(sql);
        try {
            while(rs.next()){
                if(rs.getInt("status") == 0){
                    currentRest = new RestForm(rs.getInt("restNo"));
                    currentRest.setAllDetailFromDatabase();
                } else if (rs.getInt("status") == 1){
                    RestForm rf = new RestForm(rs.getInt("restNo"));
                    rf.setAllDetailFromDatabase();
                    reservedRests.add(rf);
                }
            }
        } catch (Exception e){
            System.out.println("ERROR : @RoomDetail/setAllDetailToDatabase > " + e);
        }
    }
    
}
