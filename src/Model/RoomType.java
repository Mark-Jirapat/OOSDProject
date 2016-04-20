package Model;

import java.sql.ResultSet;

public class RoomType implements CanSetAllDetail {
    
    private int roomTypeNo;
    private String roomTypeName;
    private int amountOfBed;
    private int price;

    public RoomType(int roomTypeNo) { //NEED SET DETAIL
        this.roomTypeNo = roomTypeNo;
    }

    @Override
    public void setAllDetailFromDatabase() {
        Database database = new Database("RoomType/setAllDetailToDatabase");
        String sql = "SELECT * FROM roomType WHERE roomTypeNo = '" + roomTypeNo + "'";
        System.out.println(sql);
        ResultSet rs = database.doExecuteQuery(sql);
        try {
            if(rs.next()){
                roomTypeNo = rs.getInt("roomTypeNo");
                roomTypeName = rs.getString("roomTypeName");
                amountOfBed = rs.getInt("amountOfBed");
                price = rs.getInt("price");
            }
        } catch (Exception e){
            System.out.println("ERROR : @RoomType/setAllDetailToDatabase > " + e);
        }
    }

    public int getRoomTypeNo() {
        return roomTypeNo;
    }

    public void setRoomTypeNo(int roomTypeNo) {
        this.roomTypeNo = roomTypeNo;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public int getAmountOfBed() {
        return amountOfBed;
    }

    public void setAmountOfBed(int amountOfBed) {
        this.amountOfBed = amountOfBed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
}
