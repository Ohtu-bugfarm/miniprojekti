package bugtex.komento;

import bugtex.IO.IO;
import bugtex.IO.TiedostoonKirjoittaja;
import bugtex.bibtex.BibTeXMuotoilija;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;

import java.io.IOException;
import java.util.List;

/**
 * Komento BiBTeX-tiedoston generoinnille.
 */
public class GeneroiBibtexTiedosto implements Komento {

    public final static String KOMENTO = "generoibibtex";

    private final TietokantaRajapinta db;
    private final IO io;

    public GeneroiBibtexTiedosto(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
    }

    /**
     * Generoi tiedoston ohjelman tuntemista viitteistä.
     */
    @Override
    public void suorita() {
        String tiedostoNimi = io.lueRiviKysymyksella(">", "Anna generoitavan tiedoston nimi") + ".bib";

        TiedostoonKirjoittaja kirjoittaja;
        try {
            kirjoittaja = new TiedostoonKirjoittaja(tiedostoNimi);
        } catch (IOException ex) {
            io.tulostaRivi("Tiedoston avaaminen epäonnistui");
            return;
        }

        List<Viite> kirjoitettavat = db.annaViitteet();
        if (kirjoitettavat.isEmpty()) {
            io.tulostaRivi("Sinulla ei ole yhtään viitettä talletettuna");
            return;
        }

        if (kirjoitaViitteet(kirjoittaja, kirjoitettavat)) {
            io.tulostaRivi("Generointi onnistui\n");
        }
    }

    private boolean kirjoitaViitteet(TiedostoonKirjoittaja kirjoittaja, List<Viite> kirjoitettavat) {
        for (Viite viite : kirjoitettavat) {
            if (!kirjoittaja.kirjoita(BibTeXMuotoilija.muotoile(viite) + "\n\n")) {
                io.tulostaRivi("Tiedostoon kirjoittaminen epäonnistui");
                return false;
            }
        }

        if (!kirjoittaja.suljeKirjoittaja()) {
            io.tulostaRivi("Tiedoston sulkeminen epäonnistui");
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
