/*
This program is written by MiladZolfkhani
stID:94463172
hospital Project for Advanced Programming ZNU 97_2
*/
public class Nurce extends Staff {


    public Nurce(String fname, String lname,int type) {
        super(fname, lname,type);

    }

    @Override
    public String toString() {
        return "Nurce "+fname+" "+lname;
    }
}
