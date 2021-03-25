package Lab5.ComponetClass;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Item implements Serializable {
    private final String id;
    private final String location; //file name or Web page

    public Item(String id,String location) {
        if (id == null || id.trim().equals("")) {
            throw new IllegalArgumentException(
                    "Id should not be empty.");
        }
        this.id = id;
        if (location == null || location.trim().equals("")) {
            throw new IllegalArgumentException(
                    "Location should not be empty.");
        }
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }


}

