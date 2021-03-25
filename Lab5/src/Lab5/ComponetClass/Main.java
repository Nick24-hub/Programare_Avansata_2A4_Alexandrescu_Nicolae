package Lab5.ComponetClass;

import Lab5.Commands.*;
import Lab5.Exceptions.InvalidCommandException;
import Lab5.Exceptions.InvalidParametersException;
import com.sun.jdi.InvalidTypeException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException, ClassNotFoundException, InvalidParametersException, InvalidTypeException, Lab5.Exceptions.InvalidTypeException {
        System.out.println("Possible commands:\nload _path\nadd _type _id _name\nplay _id\nlist\nsave\nexit\n");
        Catalog catalog = new Catalog("My Books and Songs");
        Scanner scanner = new Scanner(System.in);
        while(true){
            String commandName = scanner.next();
            if(commandName.equalsIgnoreCase("exit")){
                break;
            }
            try {
                if (commandName.equalsIgnoreCase("add")) {
                    String[] params = scanner.nextLine().trim().split("\\s+");
                    try {
                        if (params.length != 3)
                            throw new InvalidParametersException();
                    } catch (InvalidParametersException e) {
                        e.printErr();
                        continue;
                    }
                    AddCommand add = new AddCommand();
                    add.addItem(catalog, params[0], params[1], params[2]);
                    continue;
                }

                if (commandName.equalsIgnoreCase("list")) {
                    ListCommand list = new ListCommand();
                    list.listCatalog(catalog);
                    continue;
                }

                if (commandName.equalsIgnoreCase("load")) {
                    String[] params = scanner.nextLine().trim().split("\\s+");
                    try {
                        if (params.length != 1)
                            throw new InvalidParametersException();
                    } catch (InvalidParametersException e) {
                        e.printErr();
                        continue;
                    }
                    LoadCommand load = new LoadCommand();
                    catalog = load.loadCatalog(params[0]);
                    continue;
                }

                if (commandName.equalsIgnoreCase("play")) {
                    String[] params = scanner.nextLine().trim().split("\\s+");
                    try {
                        if (params.length != 1)
                            throw new InvalidParametersException();
                    } catch (InvalidParametersException e) {
                        e.printErr();
                        continue;
                    }
                    PlayCommand play = new PlayCommand();
                    play.playItem(catalog, params[0]);
                    continue;
                }

                if (commandName.equalsIgnoreCase("save")) {
                    SaveCommand save = new SaveCommand();
                    save.saveCatalog(catalog);
                    continue;
                }
                throw new InvalidCommandException();
            }catch (InvalidCommandException e){
                e.printErr();
            }
        }
        /*
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
         */
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("My Books and Songs");
        var book = new Book("bestBook","D:\\Programare_Avansata_2A4_Alexandrescu_Nicolae\\Lab5\\Catalog\\java_tutorial.pdf");
        var song = new Song("bestSong","D:\\Programare_Avansata_2A4_Alexandrescu_Nicolae\\Lab5\\Catalog\\miyagi_badabum.mp3");
        catalog.add(song);
        catalog.add(book);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws IOException, ClassNotFoundException {
        Catalog catalog = CatalogUtil.load("My Books and Songs");
        CatalogUtil.play(catalog.findById("bestSong"));
        CatalogUtil.play(catalog.findById("bestBook"));
    }
}