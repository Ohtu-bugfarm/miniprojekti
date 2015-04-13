package bugtex.kayttoliittyma;

import bugtex.komento.Komentotehdas;
import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;

import java.util.NoSuchElementException;

/**
 * Tekstikäyttöliittymä ohjelmalle
 */
public class TekstiKayttoliittyma implements Kayttoliittyma, Runnable {

    private final IO io;
    private final TietokantaRajapinta db;

    /**
     * Alustaa tekstikäyttöliittymän
     * 
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public TekstiKayttoliittyma(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
    }

    @Override
    public void run() {
        Komentotehdas komennot = new Komentotehdas(io, db);
        io.tulostaRivi("Tervetuloa käyttämään bugTexiä.");

        while (true) {
            String rivi = io.lueRiviKysymyksella(">", "Anna komento");
            if (rivi.equalsIgnoreCase("poistu")) {
                break;
            }
            
            try {
                komennot.hae(rivi).suorita();
            } catch (NoSuchElementException ex) {
                break;
            }
        }
    }

}
