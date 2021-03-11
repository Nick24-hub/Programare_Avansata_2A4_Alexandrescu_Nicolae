import java.util.*;

public class City {
    private List<Location> nodes = new ArrayList<>();

    //… constructors, getters, setters

    public City() {
    }

    public City(List<Location> nodes) {
        this.nodes = nodes;
    }

    public List<Location> getNodes() {
        return nodes;
    }

    public void setNodes(List<Location> nodes) {
        this.nodes = nodes;
    }

    public void addLocation(Location node) {
        nodes.add(node);
    }

    public void displayVisitableNotPayable() {
        // creez o noua lista in care bag doar locatiile visitable care nu sunt si payable
        List<Visitable> visitable = new ArrayList<>();
        for (Location node : nodes) {
            if (node instanceof Visitable && !(node instanceof Payable)) {
                visitable.add((Visitable) node);
            }
        }
        // fac sortarea dupa ora de deschidere
        visitable.sort(new Comparator<Visitable>() {
            public int compare(Visitable l1, Visitable l2) {
                return l1.getOpeningTime().compareTo(l2.getOpeningTime());
            }
        });
        // afisez locatiile

        System.out.println("\nLocations in this city that are visitable and are not payable:");

        for (Visitable value : visitable) {
            System.out.println(value);
        }
    }

    //… toString, etc.

    @Override
    public String toString() {
        return "City{" +
                "nodes=" + nodes +
                '}';
    }
}