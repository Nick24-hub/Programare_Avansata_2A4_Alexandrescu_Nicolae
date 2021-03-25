package Lab5.ComponetClass;

import java.awt.*;
import java.io.*;

public class CatalogUtil implements Serializable {

    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getName()))) {
            oos.writeObject(catalog);
        }
    }


    public static Catalog load(String path) throws IOException, ClassNotFoundException {
        Catalog x;
        try (var ois = new ObjectInputStream(new FileInputStream(path))) {
            x = (Catalog) ois.readObject();
        }
        return x;
    }

    public static void play(Item item) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        File myFile = new File(item.getLocation());
        desktop.open(myFile);
    }

    public static void list(Catalog catalog) {
        System.out.println(catalog.toString());
    }

    public static void add(Catalog catalog, Item item) {
        catalog.add(item);
    }

}