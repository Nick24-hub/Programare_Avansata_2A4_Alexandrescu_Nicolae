import java.util.ArrayList;
import java.util.List;

public class School implements Comparable<School> {
    private final String name;
    private int capacity;
    private List<Student> preferences;

    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Student> preferences) {
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public int compareTo(School school) {
        return Integer.compare(this.capacity, school.capacity);
    }
}
