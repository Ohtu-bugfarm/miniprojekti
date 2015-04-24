package bugtex.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Luokka tiedostoon kirjoittamista varten.
 */
public class TiedostoonKirjoittaja {

    private FileWriter kirjoittaja = null;

    /**
     * Asettaa tiedoston johon kirjoitetaan.
     *
     * @param tiedostonNimi tiedostopolku kirjoitettavalle tiedostolle
     * @throws java.io.IOException
     */
    public TiedostoonKirjoittaja(String tiedostonNimi) throws IOException {
        File tiedosto = new File(tiedostonNimi);
        kirjoittaja = new FileWriter(tiedosto);
    }

    /**
     * Kirjoittaa konstruktorissa määriteltyyn tiedostoon parametrina annetun.
     * Stringin
     *
     * @param teksti tiedostoon kirjoitettava teksti.
     * @return true jos kirjoittaminen onnistuu, false muuten
     */
    public boolean kirjoita(String teksti) {
        try {
            kirjoittaja.write(teksti);
        } catch (IOException ex) {
            return false;
        }

        return true;
    }

    /**
     * Sulkee kirjoitettavan tiedoston.
     *
     * @return true jos sulkeminen onnistuu, false muuten
     */
    public boolean suljeKirjoittaja() {
        try {
            kirjoittaja.close();
        } catch (IOException ex) {
            return false;
        }

        return true;
    }

}
