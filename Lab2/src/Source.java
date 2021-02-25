public class Source {
    private String name;
    private SourceType type;

    // constructori generati de IDE

    public Source() {
    }

    public Source(String name, SourceType type) {
        this.name = name;
        this.type = type;
    }

    // setteri si getteri generati de IDE

    public SourceType getType() {
        return type;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString generat de IDE

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
