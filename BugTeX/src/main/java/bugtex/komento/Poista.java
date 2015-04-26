package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;

/**
 * Komento viitteen poistamiselle.
 */
class Poista implements Komento {

    public final static String KOMENTO = "poista";

    private final IO io;
    private final TietokantaRajapinta db;

    /**
     * Alustaa poista-komennon.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Poista(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
    }

    @Override
    public void suorita() {
        String poistettavaId = io.lueRiviKysymyksella(">", "Poistettavan viitteen id? ");

        if (db.poistaTunnuksella(poistettavaId)) {
            io.tulostaRivi("Poistettiin viite " + poistettavaId);
        } else {
            io.tulostaRivi("Poisto ei onnistunut");
        }
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
