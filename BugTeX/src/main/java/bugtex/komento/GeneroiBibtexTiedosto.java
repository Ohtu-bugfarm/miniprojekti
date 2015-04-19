package bugtex.komento;

import bugtex.IO.IO;
import bugtex.IO.Kirjoittaja;
import bugtex.bibtex.BibTeXMuotoilija;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;
import java.util.List;

public class GeneroiBibtexTiedosto implements Komento {

    public final static String KOMENTO = "gen";
    private final TietokantaRajapinta db;
    BibTeXMuotoilija muoto = new BibTeXMuotoilija();
    private final IO io;
    private final Kirjoittaja kirjoittaja;

    public GeneroiBibtexTiedosto(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
        kirjoittaja = new Kirjoittaja();
    }

    @Override
    public void suorita() {
        List<Viite> kirjoitettavat = db.annaViitteet();
        if (kirjoitettavat.isEmpty()) {
            io.tulostaRivi("Sinulla ei ole yhtään viitettä talletettuna");
            return;
        }
        for (Viite viite : kirjoitettavat) {
            kirjoittaja.kirjoita(BibTeXMuotoilija.muotoile(viite) + "\n" + "\n");
        }
        kirjoittaja.suljeKirjoittaja();
        io.tulostaRivi("Gen onnistui");
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
