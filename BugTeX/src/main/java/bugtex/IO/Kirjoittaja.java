
package bugtex.IO;

import bugtex.viite.Viite;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Kirjoittaja {

    private FileWriter writer;
    private IO io;
    private File file;
    Viite viite;

    public Kirjoittaja() {
        this.file = new File("viitteet.bib");
        try {
            writer = new FileWriter(this.file);
        } catch (IOException ex) {
            io.tulostaRivi("Avattaessa tapahtui virhe: " + ex.getMessage());
        }
    }

    public void kirjoita(String viite) {
        try {
            writer.write(viite);
            } catch (IOException ex) {
            io.tulostaRivi("Tiedostoon kirjoittaessa tapahtui virhe: " + ex.getMessage());
        }
    }

    public void suljeKirjoittaja() {
        try {
            writer.close();
        } catch (IOException ex) {
            io.tulostaRivi("Tiedoston sulkeminen ei onnistunut: " + ex.getMessage());
        }
    }
}
