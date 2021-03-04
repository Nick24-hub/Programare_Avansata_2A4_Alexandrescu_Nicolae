import java.util.HashMap;
import java.util.Map;

public abstract class Location implements Comparable<Location> {
    private final Map<Location, Integer> cost = new HashMap<>();
    private String name;
    //… constructors, getters, setters

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    public void setCost(Location node, int value) {
        cost.put(node, value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Location, Integer> getCost() {
        return cost;
    }

    //… toString, etc.


    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int compareTo(Location other) {
        if (other.name != null)
            return this.name.compareTo(other.name);
        return 0;
    }
}