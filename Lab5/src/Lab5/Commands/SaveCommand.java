package Lab5.Commands;

import Lab5.ComponetClass.Catalog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand extends Command {
    public void saveCatalog(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getName()))) {
            oos.writeObject(catalog);
        }
    }
}
