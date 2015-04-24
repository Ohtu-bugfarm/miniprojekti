package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;

/**
 * Komento viitteen poistamiselle.
 */
public class Poista implements Komento {

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
        io.tulostaRivi("Poistettiin jotakin");
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
