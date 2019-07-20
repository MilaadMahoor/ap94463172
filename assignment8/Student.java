/* This program is for
  Advanced Programming Course 972 ZNU
  Assignment 8
  98/02/22
  Milad Zolfkhani
  94463172
 */



public abstract class Student implements Comparable<Student> {

    public int studentId;
    public String firstName;
    public String lastName;

    public Student(){



    }
    public abstract int getStudentId();


    public String toString() {

        return super.toString();
    }
    @Override
    public  int compareTo(Student o) {
        if (studentId <o.studentId) {
            return(this.getStudentId());
        }
        return o.studentId;
    }
}
