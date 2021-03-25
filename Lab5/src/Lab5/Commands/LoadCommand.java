package Lab5.Commands;

import Lab5.ComponetClass.Catalog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCommand extends Command{
    public Catalog loadCatalog(String path) throws IOException, ClassNotFoundException {
        Catalog x;
        try (var ois = new ObjectInputStream(new FileInputStream(path))) {
            x = (Catalog) ois.readObject();
        }
        return x;
    }
}
