package Model;

import java.sql.ResultSet;

public class Room implements CanSetAllDetail {
    
    private int roomNo;
    private int floorNo;
    private RoomType roomType;

    public Room(int roomNo) { //NEED SET DETAIL
        this.roomNo = roomNo;
    }

    @Override
    public void setAllDetailFromDatabase() {
        Database database = new Database("Room/setAllDetailToDatabase");
        String sql = "SELECT * FROM room WHERE roomNo = '" + roomNo + "'";
        System.out.println(sql);
        ResultSet rs = database.doExecuteQuery(sql);
        try {
            if(rs.next()){
                roomNo = rs.getInt("roomNo");
                floorNo = rs.getInt("floorNo");
                roomType = new RoomType(rs.getInt("roomTypeNo"));
                roomType.setAllDetailFromDatabase();
            }
        } catch (Exception e){
            System.out.println("ERROR : @Room/setAllDetailToDatabase > " + e);
        }
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
    
    
    
    
    
}
