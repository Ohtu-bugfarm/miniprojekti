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

    /**
     * Konstrukroi kirjoittaja luokan
     * 
     * @param tiedostonNimi tiedoston nimi
     */
    public Kirjoittaja(String tiedostonNimi) {
        this.file = new File(tiedostonNimi);
        try {
            writer = new FileWriter(this.file);
        } catch (IOException ex) {
            io.tulostaRivi("Avattaessa tapahtui virhe: " + ex.getMessage());
        }
    }
    
    /**
     * Kirjoittaa konstruktorissa määriteltyyn tiedostoon parametrinä annetun Stringin.
     * 
     * @param teksti tiedostoon kirjoitettava teksti.
     * @throws java.io.IOException 
     */
    public void kirjoita(String teksti) {
        try {
            writer.write(teksti);
        } catch (IOException ex) {
            io.tulostaRivi("Tiedostoon kirjoittaessa tapahtui virhe: " + ex.getMessage());
        }
    }

    /**
     * Sulkee kirjoitettavan tiedoston
     * 
     * @throws java.io.Exception
     */
    public void suljeKirjoittaja() {
        try {
            writer.close();
        } catch (IOException ex) {
            io.tulostaRivi("Tiedoston sulkeminen ei onnistunut: " + ex.getMessage());
        }
    }
}
