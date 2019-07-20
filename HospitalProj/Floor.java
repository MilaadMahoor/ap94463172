/*
This program is written by MiladZolfkhani
stID:94463172
hospital Project for Advanced Programming ZNU 97_2
*/

import java.util.ArrayList;

public class Floor {
    public ArrayList<Room> e = new ArrayList();
    int floornumber;


    public Floor() {
    }


    public void roomSet(int floornumber) {
        Room icuRoom = new ICU(1);
        Room sterilizedRoom = new Sterilized(3);
        Room emergency = new Emergency(2);
        ((ICU) icuRoom).floornumber=floornumber;
        ((Sterilized) sterilizedRoom).floornumber=floornumber;
        ((Emergency) emergency).floornumber=floornumber;
        this.floornumber=floornumber;
        e.add(icuRoom);
        e.add(emergency);
        e.add(sterilizedRoom);

    }











 }












