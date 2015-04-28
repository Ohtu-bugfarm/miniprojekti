package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;

import java.util.List;

/**
 * Komento kaikkien viitteiden listaamiselle.
 */
class Listaa extends Komento {

    public final static String KOMENTO = "listaa";

    /**
     * Alustaa Listaa-komennon.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Listaa(IO io, TietokantaRajapinta db) {
        super(io, db);
    }

    @Override
    public void suorita() {
        List<Viite> tulostettava = db.annaViitteet();

        for (Viite viite: tulostettava) {
            io.tulostaRivi(viite.getTyyppi());
            io.tulostaRivi(viite.toString());
        }

        io.tulostaRivi("Viitteitä tietokannassa yhteensä " + db.annaViitteet().size());
        io.tulostaRivi("");
    }

}
