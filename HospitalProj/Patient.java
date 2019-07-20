/*
This program is written by MiladZolfkhani
stID:94463172
hospital Project for Advanced Programming ZNU 97_2
*/
public class Patient {

    public String fname,lname;

    public int roomtype;
    Room room;

    public Patient(String fname, String lname, int roomtype,Room room) {
        this.fname = fname;
        this.lname = lname;
        this.roomtype = roomtype;
        this.room=room;
    }

    public String toString(){
        return fname+" "+lname;
    }

}
