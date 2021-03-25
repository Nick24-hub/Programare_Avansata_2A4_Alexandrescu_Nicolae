package Lab5.Commands;

import Lab5.ComponetClass.Catalog;

public class ListCommand extends Command {
    public void listCatalog(Catalog catalog) {
        System.out.println("Items of the catalog: " + catalog.toString());
    }
}
