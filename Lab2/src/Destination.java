public class Destination {
    private String name;

    // constructori generat de IDE

    public Destination() {
    }

    public Destination(String name) {
        this.name = name;
    }

    //setter generat de IDE

    public String getName() {
        return name;
    }

    // getter generat de IDE

    public void setName(String name) {
        this.name = name;
    }

    // toString generat de IDE

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                '}';
    }
}
