import java.util.Arrays;

public class Problem {
    private Source[] sources;
    private Destination[] destinations;
    private int[] supply;
    private int[] demand;
    private int[][] cost;

    // Constructor generat de IDE
    public Problem() {
    }


    public Source[] getSources() {
        return sources;
    }

    // setSources verifica daca vectorul de surse are elemente distincte inainte de a le salva

    public boolean setSources(Source[] sources) {
        for (int i = 0; i < sources.length - 1; i++) {
            for (int j = i + 1; j < sources.length; j++) {
                if (sources[i].equals(sources[j])) {
                    System.out.println("Eroare la setSources, nu poti introduce aceeasi sursa de doua ori!");
                    return false;
                }
            }
        }
        this.sources = sources;
        return true;
    }

    public Destination[] getDestinations() {
        return destinations;
    }


    // setDestinations verifica daca vectorul de destinatii are elemente distincte inainte de a le salva

    public boolean setDestinations(Destination[] destinations) {
        for (int i = 0; i < destinations.length - 1; i++) {
            for (int j = i + 1; j < destinations.length; j++) {
                if (destinations[i].equals(destinations[j])) {
                    System.out.println("Eroare la setDestinations, nu poti introduce aceeasi destinatie de doua ori!");
                    return false;
                }
            }
        }
        this.destinations = destinations;
        return true;
    }

    public int[] getSupply() {
        return supply;
    }

    public void setSupply(int[] supply) {
        this.supply = supply;
    }

    public int[] getDemand() {
        return demand;
    }

    public void setDemand(int[] demand) {
        this.demand = demand;
    }

    public int[][] getCost() {
        return cost;
    }

    public void setCost(int[][] cost) {
        this.cost = cost;
    }

    private String matrixToString(int [][] m) {
        String s = "";
        for (int i = 0; i < m.length; i++) {
            s += Arrays.toString((m[i]));
        }
        return s;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "sources=" + Arrays.toString(sources) +
                ", destinations=" + Arrays.toString(destinations) +
                ", supply=" + Arrays.toString(supply) +
                ", demand=" + Arrays.toString(demand) +
                ", cost=" + matrixToString(cost) +
                '}';
    }
}
