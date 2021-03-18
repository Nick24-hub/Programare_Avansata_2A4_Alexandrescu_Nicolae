package Lab5;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog =
                new Catalog("My Books", "");
        var song = new Song("bestBook", "java_tutorial.pdf", "D:\\Programare_Avansata_2A4_Alexandrescu_Nicolae\\Lab5\\Catalog\\" );
        var book = new Book("bestSong", "miyagi_badabum.mp3", "D:\\Programare_Avansata_2A4_Alexandrescu_Nicolae\\Lab5\\Catalog\\" );
        catalog.add(song);
        catalog.add(book);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws IOException, ClassNotFoundException {
        Catalog catalog = CatalogUtil.load("My Books");
        CatalogUtil.view(catalog.findById("bestSong"));
        CatalogUtil.view(catalog.findById("bestBook"));
    }
}