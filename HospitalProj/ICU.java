/*
This program is written by MiladZolfkhani
stID:94463172
hospital Project for Advanced Programming ZNU 97_2
*/

public class ICU extends Room {

    private int roomtype;
    private int roomCapacity=3;
    String name="ICU";
    public int floornumber;
    public ICU(int roomtype) {

        this.roomtype=roomtype;
    }

    @Override
    public String toString() {
        return "ICU in Floor"+floornumber+" with "+ roomCapacity+ " remaining free beds";
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
