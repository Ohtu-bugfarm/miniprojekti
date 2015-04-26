package bugtex.komento;

import bugtex.IO.IO;
import bugtex.bibtex.BibTeXMuotoilija;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;

/**
 * Komento yksittäisen viitteen tarkasteluun BibTeX-muodossa viitteen id:n perusteella.
 */
class TarkasteleBibtex implements Komento {

    public final static String KOMENTO = "bibtex";

    private final IO io;
    private final TietokantaRajapinta db;

    /**
     * Alustaa TarkasteleBibtex-komennon.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public TarkasteleBibtex(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
    }

    @Override
    public void suorita() {
        String tunnus = io.lueRiviKysymyksella(">", "viitteen tunnus?");
        Viite tarkasteltava = db.haeTunnuksella(tunnus);

        if (tarkasteltava == null) {
            io.tulostaRivi("Hakemaasi viitettä ei löytynyt!");
        } else {
            io.tulostaRivi(BibTeXMuotoilija.muotoile(tarkasteltava));
        }

        io.tulostaRivi("");
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
