package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;
import bugtex.bibtex.BibTeXMuotoilija;
import java.util.List;

/**
 * listaa kaikki viitteet bibtex-muodossa
 */
public class ListaaBibtex implements Komento {

    public final static String KOMENTO = "listaabibtex";

    private final IO io;
    private final TietokantaRajapinta db;

    /**
     * Alustaa ListaaBibtex-komennon
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public ListaaBibtex(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
    }

    @Override
    public void suorita() {
        List<Viite> tulostettava = db.annaViitteet();

        if (tulostettava.isEmpty()) {
            io.tulostaRivi("Viitteitä ei löytynyt");
        }

        for (Viite viite : tulostettava) {
            io.tulostaRivi(BibTeXMuotoilija.muotoile(viite) + "\n");
        }
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
