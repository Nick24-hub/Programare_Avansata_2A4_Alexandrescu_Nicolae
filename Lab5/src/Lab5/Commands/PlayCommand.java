package Lab5.Commands;

import Lab5.ComponetClass.Catalog;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PlayCommand extends Command{
    public void playItem(Catalog catalog, String id) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        File myFile = new File(catalog.findById(id).getLocation());
        desktop.open(myFile);
    }
}
