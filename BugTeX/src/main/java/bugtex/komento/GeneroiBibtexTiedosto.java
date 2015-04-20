package bugtex.komento;

import bugtex.IO.IO;
import bugtex.bibtex.BibTeXMuotoilija;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;
import java.util.List;

public class GeneroiBibtexTiedosto implements Komento {

    public final static String KOMENTO = "gen";
    private final TietokantaRajapinta db;
    BibTeXMuotoilija muoto = new BibTeXMuotoilija();
    private final IO io;

    public GeneroiBibtexTiedosto(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
    }

    /**
     * Generoi tiedoston ohjelman tuntemista viitteistä
     */
    @Override
    public void suorita() {

        io.asetaTiedosto(io.lueRiviKysymyksella(">", "Anna generoitavan tiedoston nimi") + ".bib");
        List<Viite> kirjoitettavat = db.annaViitteet();
        if (kirjoitettavat.isEmpty()) {
            io.tulostaRivi("Sinulla ei ole yhtään viitettä talletettuna");
            return;
        }
        for (Viite viite : kirjoitettavat) {
            io.kirjoita(BibTeXMuotoilija.muotoile(viite) + "\n" + "\n");
        }
        io.suljeKirjoittaja();
        io.tulostaRivi("Gen onnistui");
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
