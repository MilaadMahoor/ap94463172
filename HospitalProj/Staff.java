/*
This program is written by MiladZolfkhani
stID:94463172
hospital Project for Advanced Programming ZNU 97_2
*/
public abstract class Staff {



    String fname,lname;
    int type;

    public Staff(String fname, String lname, int type) {
        this.fname = fname;
        this.lname = lname;
        this.type = type;
    }

    public abstract String toString();
}
