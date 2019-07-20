import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Course {

    private String coureName;
    private int value;
    private ClassRoom classRoom;
    private Master courseTeacher;
    private Set<Student> students = new HashSet<>();


    public Course(String coureName, int value) {
        this.coureName = coureName;
        this.value = value;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
    public String getCoureName() {
        return coureName;
    }
    public int getValue() {
        return value;
    }
    public ClassRoom getClassRoom() {
        return classRoom;
    }
    public Master getCourseTeacher() {
        return courseTeacher;
    }
    public void setCourseTeacher(Master courseTeacher) {

        courseTeacher.setMastersCourses(this);
        this.courseTeacher = courseTeacher;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(coureName, course.coureName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(coureName);
    }

    @Override

    public String toString() {
        return coureName + '\t' + value +"\t"+getClassRoom().toString();
    }


    public void setStudent(Student student){
        students.add(student);
    }


    public void remStudent(Student student){
        students.remove(student);
    }


    public Set<Student> getStudents() {
        return students;
    }



}
