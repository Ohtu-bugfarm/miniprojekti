package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;

import java.util.List;

/**
 * Rajapinta ohjelman tukemalle komennolla.
 */
public abstract class Komento {

    protected final IO io;
    protected final TietokantaRajapinta db;

    /**
     * Alustaa Komento-olion.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Komento(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
    }

    /**
     * Alustaa Komento-olion.
     *
     * @param io Käytettävä IO-luokka
     */
    public Komento(IO io) {
        this(io, null);
    }

    /**
     * Aja komento.
     */
    public abstract void suorita();

    /**
     * Tulostaa tietokannassa olevien viitteiden tunnukset.
     */
    protected void tulostaViitteidenTunnukset() {
        List<Viite> viitteet = db.annaViitteet();

        for (int i = 1; i <= viitteet.size(); ++i) {
            io.tulostaRivi(i + ") " + viitteet.get(i - 1).getTunnus());
        }

        io.tulostaRivi("");
    }

    protected Viite haeViiteNumerolla(int nro) {
        List<Viite> viitteet = db.annaViitteet();

        if (nro < 1 || nro > viitteet.size()) {
            return null;
        }

        return viitteet.get(nro - 1);
    }

}
