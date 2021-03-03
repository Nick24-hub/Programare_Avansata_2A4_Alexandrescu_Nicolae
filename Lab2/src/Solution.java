import java.util.Arrays;

public class Solution {
    private int[][] x;
    //x[i][j] = how many units Si supplies to Dj

    // Constructor generat de IDE
    public Solution() {

    }

    //Getter si setter generat de IDE

    public int[][] getX() {
        return x;
    }

    public void setX(int[][] x) {
        this.x = x;
    }

    // computeCost returneaza costul total
    public int computeCost(Problem pb) {
        int costTotal = 0;
        int[][] cost = pb.getCost();
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                costTotal += cost[i][j] * x[i][j];
            }
        }
        return costTotal;
    }

    private String matrixToString(int [][] m) {
        String s = "";
        for (int i = 0; i < m.length; i++) {
            s += Arrays.toString((m[i]));
        }
        return s;
    }

    // toString generat de IDE
    @Override
    public String toString() {
        return "Solution{" +
                "x=" + matrixToString(x) +
                '}';
    }
}
