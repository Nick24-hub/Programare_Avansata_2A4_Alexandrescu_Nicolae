import sun.java2d.pipe.SolidTextRenderer;

import java.util.Arrays;

public class GreedyAlgorithm extends Algorithm {
    private Problem problemData;

    // Constructor generat de IDE
    public GreedyAlgorithm(Problem problemData) {
        this.problemData = problemData;
    }

    // Getter si setter generati de IDE
    @Override
    public Problem getProblemData() {
        return problemData;
    }

    @Override
    public void setProblemData(Problem problemData) {
        this.problemData = problemData;
    }


    // Functie care returneaza maximul dintr-un vector de tip int
    private int max(int[] v) {
        int maxim = v[0];
        for (int i = 0; i < v.length; i++) {
            if (maxim < v[i]) {
                maxim = v[i];
            }
        }
        return maxim;
    }

    @Override
    public Solution solve() {
        int[][] cost = problemData.getCost();
        int[] supply = problemData.getSupply();
        int[] demand = problemData.getDemand();
        int[][] x = new int[cost.length][cost[0].length];
        int i,j;
        // initializez vectorul pentru solutie
        for (i = 0; i < x.length; i++) {
            for (j = 0; j < x[0].length; j++) {
                x[i][j] = 0;
            }
        }
        int costMin, destCostMin = 0;
        for (i = 0; i < cost.length; i++) {

            while (supply[i] > 0 && max(demand) > 0) {
                costMin = Integer.MAX_VALUE;
                // Caut destinatia ce impune cost minim pentru sursa i
                for (j = 0; j < cost[0].length; j++) {
                    if (cost[i][j] < costMin && demand[j] > 0) {
                        costMin = cost[i][j];
                        destCostMin = j;
                    }
                }
                // Salvez in x cate unitati trimit la destinatie
                if (demand[destCostMin] >= supply[i]) {
                    x[i][destCostMin] = supply[i];
                    demand[destCostMin] -= supply[i];
                    supply[i] = 0;
                } else {
                    x[i][destCostMin] = demand[destCostMin];
                    supply[i] -= demand[destCostMin];
                    demand[destCostMin] = 0;
                }
            }
        }
        Solution sol = new Solution();
        sol.setX(x);
        return sol;
    }
}
