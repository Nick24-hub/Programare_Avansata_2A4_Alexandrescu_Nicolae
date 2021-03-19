import java.util.Map;

public class Solution {
    private Map<Student,School> solution;

    public Map<Student, School> getSolution() {
        return solution;
    }

    public void setSolution(Map<Student, School> solution) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "solution=" + solution +
                '}';
    }
}
