/*
This program is written by MiladZolfkhani
stID:94463172
hospital Project for Advanced Programming ZNU 97_2
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {
    public Scanner sc = new Scanner(System.in);
    ArrayList<Floor>floors = new ArrayList();
    ArrayList<Patient> patients = new ArrayList();
    ArrayList<Staff> staffs = new ArrayList();
    ArrayList<Room> rooms= new ArrayList();
    public Hospital() {
    }

    public void setFloors(){
        for (int i = 1; i <=3 ; i++) {
            Floor floor = new Floor();
            floor.roomSet(i);

            floors.add(floor);

        }
        for (int i = 0; i <floors.size() ; i++) {
            for (int j = 0; j < floors.get(i).e.size() ; j++) {
                rooms.add(floors.get(i).e.get(j));
            }
        }

    }

    public void acceptPatient(Room e, Patient p){


        e.changeRoomCapacity(-1);
        System.out.println(p.fname+" "+p.lname+" is accepted in Room:"+e.toString());


    }

    public void help(){
        System.out.println("assign: assigns a new Patient \n" +
                "dismiss: dismiss a Patient\n" +
                "showStaff: shows whom are working in the hospital\n" +
                "showDoc: shows only hospital's Doctors\n" +
                "showNur: shows only hospital's Nurces\n" +
                "hire: hires a Doctor/Nurce for hospital\n" +
                "fire: fires your choosen doctor/Nurce\n" +
                "showRooms: shows all hospital's Rooms with their floor numbers and current Capacity\n" +
                "showPat: shows all hospitals Patients Name\n" +
                "exit: exits program");
    }

    public void assign(){
        System.out.println("enter your Patients First name:");
        String fname= sc.next();
        System.out.println("enter your Patients Last name:");
        String lname = sc.next();

        System.out.println("What type of Room you want: Emergency,ICU,Sterilized");
        String roomtype = sc.next();
        switch (roomtype){
            case "Emergency":
            {
                for (Room room:rooms){
                    if(room.roomType()==2 && room.isEmpty()){
                        Patient patient = new Patient(fname,lname,room.roomType(),room);

                        acceptPatient(room,patient);
                        patients.add(patient);
                        System.out.println("Done!");
                        break;

                    }
                }
                break;
            }
            case "ICU":
            {
               for (Room room:rooms){
                   if(room.roomType()==1 && room.isEmpty()){
                       Patient patient = new Patient(fname,lname,room.roomType(),room);
                       acceptPatient(room,patient);
                       patients.add(patient);
                       System.out.println("Done!");
                       break;

                   }
               }
                break;
            }
            case "Sterilized":
            {
                for (Room room:rooms){
                    if(room.roomType()==3 && room.isEmpty()){
                        Patient patient = new Patient(fname,lname,room.roomType(),room);
                        acceptPatient(room,patient);
                        patients.add(patient);
                        System.out.println("Done!");
                        break;

                    }
                }
                break;
            }
            default:{
                System.out.println("Invalid");
                break;
            }

        }
    }

    public void dismiss(){

        System.out.println("your Patient's first name:");
        String fname = sc.next();
        System.out.println("your Patient's last name:");
        String lname =sc.next();

        for (int i = 0; i < patients.size(); i++) {


            for (int j = 0; j <rooms.size() ; j++) {
                if(patients.get(i).roomtype==rooms.get(j).roomType()){
                            patients.get(i).room.changeRoomCapacity(+1);
                }break;
            }
            if(lname.equalsIgnoreCase(patients.get(i).lname)&&fname.equalsIgnoreCase(patients.get(i).fname)){
                patients.remove(i);

            }

            System.out.println("Done");
        }






    }

    public void showStaff(){
        for (int i = 0; i < staffs.size(); i++) {
            System.out.println(staffs.get(i).toString());
        }

    }


    public void addDoc(){
        System.out.println("Doctor's First Name:");
        String fname = sc.next();
        System.out.println("Last name:");
        String lname = sc.next();
        Staff dr = new Doctor(fname,lname,1);
        staffs.add(dr);
        System.out.println("Done");

    }
    public void addNur(){
        System.out.println("Nurce's First Name:");
        String fname = sc.next();
        System.out.println("Last name:");
        String lname = sc.next();
        Staff nu = new Nurce(fname,lname,2);
        staffs.add(nu);
        System.out.println("Done");
    }
    public void fireStaff(){
        for (int i = 0; i <staffs.size() ; i++) {
            staffs.get(i).toString();
        }
        System.out.println("write your staff's last name:");
        String lname = sc.next();
        for (int i = 0; i <staffs.size() ; i++) {
            if(staffs.get(i).lname.equalsIgnoreCase(lname)){
                System.out.println("Write first name:");
                String fname = sc.next();
                if(staffs.get(i).fname.equalsIgnoreCase(fname)){
                    System.out.println(staffs.get(i).toString()+"is removed");
                    staffs.remove(i);
                }else {
                    System.out.println("invalid!");
                }
            }
            else {
                System.out.println("Invalid");
            }
        }
    }
    public void showDoc(){
        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i).type==1){
                System.out.println(staffs.get(i).toString());
            }
        }
    }
    public void showNur(){
        for (int i = 0; i <staffs.size() ; i++) {
            if (staffs.get(i).type==2){
                System.out.println(staffs.get(i).toString());
            }
        }
    }

    public void showPat(){
        for (int i = 0; i <patients.size() ; i++) {
            System.out.println(patients.get(i).toString());
        }
    }
    public void showRooms(){
        for (int i = 0; i <rooms.size() ; i++) {
            System.out.println(rooms.get(i).toString());
        }
    }
}

