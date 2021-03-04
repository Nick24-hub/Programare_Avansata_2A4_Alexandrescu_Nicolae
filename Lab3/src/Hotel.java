import java.util.Map;

public class Hotel extends Location implements Classifiable {
    private double rank;

    public Hotel(String name, double rank) {
        super(name);
        if (rank >= 1 && rank <= 5)
            this.rank = rank;
    }

    public Hotel(double rank) {
        if (rank >= 1 && rank <= 5)
            this.rank = rank;
    }

    @Override
    public double getRank() {
        return rank;
    }

    // daca este o valoare de la 1 la 5 atunci o salvez
    public void setRank(double rank) {
        if (rank >= 1 && rank <= 5)
            this.rank = rank;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setCost(Location node, int value) {
        super.setCost(node, value);
    }

    @Override
    public Map<Location, Integer> getCost() {
        return super.getCost();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getDetails() {
        return "Hotel{ name='" + super.getName() + "', rank=" + rank + '}';
    }
}
