package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;

/**
 * Komento yksittäisen viitteen tarkasteluun viitteen id:n perusteella
 */
public class Tarkastele implements Komento {

    private final IO io;
    private final TietokantaRajapinta db;

    /**
     * Alustaa tarkastele-komennon
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
        String id = io.lueRiviKysymyksella(">", "viitteen id?");

        Viite tarkasteltava = db.haeTunnuksella(Integer.parseInt(id));

        if (tarkasteltava == null) {
            io.tulostaRivi("Hakemaasi viitettä ei löytynyt!");
        } else {
            io.tulostaRivi(tarkasteltava.toString());
            
        }
    }

}
