/* This program is for
  Advanced Programming Course 972 ZNU
  Assignment 8
  98/02/22
  Milad Zolfkhani
  94463172
 */


public class StudingStudent extends Student {


    public int iD ;
    public int studentId;
    public String firstName;
    public String lastName;
    public int expendedUnits;

    public StudingStudent(int iD,String firstName,String lastName,int studentId,int expendedUnits){

        this.iD= iD;
        this.studentId = studentId;
        this.firstName= firstName;
        this.lastName= lastName;
        if (expendedUnits<250){
            try {
                this.expendedUnits = expendedUnits;
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
        return iD+"\t"+firstName+"\t"+lastName+"\t"+studentId+"\t"+ expendedUnits+"\t";
    }
}
