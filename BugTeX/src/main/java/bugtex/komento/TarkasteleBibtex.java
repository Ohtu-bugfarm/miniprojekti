package bugtex.komento;

import bugtex.IO.IO;
import bugtex.bibtex.BibTeXMuotoilija;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;

/**
 * Komento yksittäisen viitteen tarkasteluun BibTeX-muodossa viitteen id:n perusteella.
 */
class TarkasteleBibtex extends Komento {

    public final static String KOMENTO = "bibtex";

    /**
     * Alustaa TarkasteleBibtex-komennon.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public TarkasteleBibtex(IO io, TietokantaRajapinta db) {
        super(io, db);
    }

    @Override
    public void suorita() {
        tulostaViitteidenTunnukset();
        int nro = io.lueNumeroKysymyksella(">", "tarkasteltavan viitteen numero?");
        Viite tarkasteltava = haeViiteNumerolla(nro);

        if (tarkasteltava == null) {
            io.tulostaRivi("Hakemaasi viitettä ei löytynyt!\n");
        } else {
            io.tulostaRivi(BibTeXMuotoilija.muotoile(tarkasteltava) + "\n");
        }
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
