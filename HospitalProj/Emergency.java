/*
This program is written by MiladZolfkhani
stID:94463172
hospital Project for Advanced Programming ZNU 97_2
*/
public class Emergency extends Room {

    private int roomtype;
    String name="Emergency";
    private int roomCapacity = 2;
    public int floornumber;
    public Emergency(int roomtype) {

        this.roomtype=roomtype;

    }


    @Override
    public String toString() {
        return "Emergency in Floor"+floornumber+" with "+ roomCapacity+ " remaining free beds";
    }

    @Override
    public int roomType() {
        return roomtype;
    }


    @Override
    public void changeRoomCapacity(int number) {
        roomCapacity=roomCapacity+number;

    }


    @Override
    public boolean isEmpty() {
        if(roomCapacity ==0){
            return false;
        }else {
            return true;
        }
    }

}
