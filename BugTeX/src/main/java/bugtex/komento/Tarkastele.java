package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;

/**
 * Komento yksittäisen viitteen tarkasteluun viitteen id:n perusteella.
 */
class Tarkastele implements Komento {

    public final static String KOMENTO = "tarkastele";

    private final IO io;
    private final TietokantaRajapinta db;

    /**
     * Alustaa tarkastele-komennon.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Tarkastele(IO io, TietokantaRajapinta db) {
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
            io.tulostaRivi(tarkasteltava.toString());
        }
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
