package Lab5;

import java.awt.*;
import java.io.*;

public class CatalogUtil implements Serializable {
    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()+catalog.getName()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws IOException, ClassNotFoundException {
        Catalog x;
        try (var ois = new ObjectInputStream(
                new FileInputStream((path)))) {
            x = (Catalog) ois.readObject();
        }
        return x;
    }


    

    public static void view(Item item) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        //… browse or open, depending of the location type
        File myFile = new File(item.getLocation()+item.getName());
        desktop.open(myFile);
    }
}