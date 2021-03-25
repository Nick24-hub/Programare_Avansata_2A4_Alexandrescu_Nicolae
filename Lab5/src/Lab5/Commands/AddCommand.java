package Lab5.Commands;

import Lab5.ComponetClass.Book;
import Lab5.ComponetClass.Catalog;
import Lab5.Exceptions.InvalidTypeException;
import Lab5.ComponetClass.Song;

public class AddCommand extends Command {

    public void addItem(Catalog catalog, String type, String id, String location) throws InvalidTypeException {
        try{
            if (type.equalsIgnoreCase("song"))
                catalog.add(new Song(id, location));
            else if (type.equalsIgnoreCase("book"))
                catalog.add(new Book(id, location));
            else throw new InvalidTypeException();
        } catch (InvalidTypeException e) {
            e.printErr();
        }
    }

}
