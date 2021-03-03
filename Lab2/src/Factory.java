public class Factory extends Source {

    private String name;

    // Constructori generati de IDE
    public Factory() {
    }

    public Factory(String name) {
        this.name = name;
    }

    // Getter si setter generati de IDE
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName() {
        this.name = "S1";
    }

    // toString generat de IDE
    @Override
    public String toString() {
        return "Factory{" +
                "name='" + name + '\'' +
                '}';
    }

    // equals generat de IDE
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
