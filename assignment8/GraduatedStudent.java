/* This program is for
  Advanced Programming Course 972 ZNU
  Assignment 8
  98/02/22
  Milad Zolfkhani
  94463172
 */


public class GraduatedStudent extends Student {

    public  int iD = 1;
    public int studentId;
    public String firstName;
    public String lastName;
    public int graduationYear;

    public GraduatedStudent(int iD,String firstName, String lastName, int studentId, int graduationYear){

        this.iD =iD;
        this.studentId = studentId;
        this.firstName= firstName;
        this.lastName= lastName;
        if (graduationYear>1380){
        try {
            this.graduationYear = graduationYear;
        }catch (Exception e){
            System.out.println("error this will be deleted");
        }
        }
    }

    @Override
    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return iD+"\t"+firstName+"\t"+lastName+"\t"+studentId+"\t"+ graduationYear+"\t";
    }



}
