/*
This program is written by MiladZolfkhani
stID:94463172
hospital Project for Advanced Programming ZNU 97_2
*/

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Hospital hospital = new Hospital();
        hospital.setFloors();
        String command;
        System.out.println("Welcome to Hospital");
        System.out.println("Set your Command\n" +
                "If you dont know them type help\n" +
                "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");

        command = sc.next();
        while (command!="exit") {


            switch (command) {

                case "help": {
                   hospital.help();
                    command=sc.next();
                    break;
                }

                case "assign":
                {
                  hospital.assign();
                    command=sc.next();
                    break;
                }
                case "dismiss":
                {
                    hospital.dismiss();
                    command=sc.next();
                    break;
                }
                case "showRooms":
                {
                    hospital.showRooms();
                    command=sc.next();
                    break;
                }



                case "showStaff":
                {
                    hospital.showStaff();
                    command=sc.next();
                    break;
                }

                case "showDoc":{
                    hospital.showDoc();
                    command=sc.next();
                    break;
                }
                case "showNur":{
                    hospital.showNur();
                    command=sc.next();
                    break;
                }
                case "hire":{
                    System.out.println("Dr/Nurce");
                    String temp = sc.next();
                    switch (temp){
                        case"Dr":{
                            hospital.addDoc();
                            break;
                        }
                        case "Nurce":{
                            hospital.addNur();
                            break;
                        }
                        default:{
                            System.out.println("Invalid");
                        }
                    }
                    command=sc.next();
                    break;
                }
                case "fire":{
                    hospital.fireStaff();
                    command=sc.next();
                    break;
                }
                case "exit":
                {
                    command="";
                    return;
                }
                case "showPat":
                {
                    hospital.showPat();
                    command=sc.next();
                    break;
                }
                default:{
                    System.out.println("Invalid");
                    command=sc.next();
                    break;
                }



            }
        }



    }
}
