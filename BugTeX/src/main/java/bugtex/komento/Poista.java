package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;

/**
 * Komento viitteen poistamiselle.
 */
class Poista extends Komento {

    public final static String KOMENTO = "poista";

    /**
     * Alustaa poista-komennon.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Poista(IO io, TietokantaRajapinta db) {
        super(io, db);
    }

    @Override
    public void suorita() {
        tulostaViitteidenTunnukset();
        int nro = io.lueNumeroKysymyksella(">", "poistettavan viitteen numero?");
        Viite poistettava = haeViiteNumerolla(nro);

        if (poistettava != null && db.poistaTunnuksella(poistettava.getTunnus())) {
            io.tulostaRivi("Poistettiin viite " + poistettava.getTunnus() + "\n");
        } else {
            io.tulostaRivi("Poisto ei onnistunut\n");
        }
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
