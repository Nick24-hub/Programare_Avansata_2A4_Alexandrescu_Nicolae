import java.util.List;

public class Problem {
    private int stdNumber,schNumber;
    private List <Student> studentList;
    private List <School> schoolList;

    public int getStdNumber() {
        return stdNumber;
    }

    public void setStdNumber(int stdNumber) {
        this.stdNumber = stdNumber;
    }

    public int getSchNumber() {
        return schNumber;
    }

    public void setSchNumber(int schNumber) {
        this.schNumber = schNumber;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<School> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "stdNumber=" + stdNumber +
                ", schNumber=" + schNumber +
                ", studentList=" + studentList +
                ", schoolList=" + schoolList +
                '}';
    }
}
