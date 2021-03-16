import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    private final String name;
    private float grade;
    private List<School> preferences = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public List<School> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<School> preferences) {
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public int compareTo(Student student) {
        return Float.compare(this.grade, student.grade);
    }
}
