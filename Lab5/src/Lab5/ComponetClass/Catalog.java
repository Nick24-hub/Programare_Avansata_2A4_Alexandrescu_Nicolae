package Lab5.ComponetClass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private final String name;
    private List<Item> items = new ArrayList<>();

    public Catalog(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException(
                    "Name should not be empty.");
        }
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void add(Item item) {
        items.add(item);
    }


    @Override
    public String toString() {
        StringBuilder itemsId = new StringBuilder("");
        for(Item item : items)
        {
            itemsId.append(item.getId());
            itemsId.append(", ");
        }
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items= " + itemsId +
                '}';
    }

    public Item findById(String id) {
        return items.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

}


