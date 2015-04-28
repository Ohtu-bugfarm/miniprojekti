package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;

/**
 * Komento yksittäisen viitteen tarkasteluun viitteen id:n perusteella.
 */
class Tarkastele extends Komento {

    public final static String KOMENTO = "tarkastele";

    /**
     * Alustaa tarkastele-komennon.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Tarkastele(IO io, TietokantaRajapinta db) {
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
            io.tulostaRivi(tarkasteltava.toString());
        }
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
