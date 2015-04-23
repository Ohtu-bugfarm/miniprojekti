package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;

import java.util.List;

/**
 * Komento kaikkien viitteiden listaamiselle.
 */
public class Listaa implements Komento {

    public final static String KOMENTO = "listaa";

    private final IO io;
    private final TietokantaRajapinta db;

    /**
     * Alustaa Listaa-komennon.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Listaa(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
    }

    @Override
    public void suorita() {
        List<Viite> tulostettava = db.annaViitteet();

        if (tulostettava.isEmpty()) {
            io.tulostaRivi("Viitteitä ei löytynyt\n");
        }

        for (Viite viite: tulostettava) {
            io.tulostaRivi(viite.toString());
        }
    }

}
