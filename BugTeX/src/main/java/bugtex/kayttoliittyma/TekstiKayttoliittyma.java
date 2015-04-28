package bugtex.kayttoliittyma;

import bugtex.komento.Komentotehdas;
import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;

import java.util.NoSuchElementException;

/**
 * Tekstikäyttöliittymä ohjelmalle.
 */
public class TekstiKayttoliittyma implements Kayttoliittyma, Runnable {

    private final IO io;
    private final TietokantaRajapinta db;
    private final Komentotehdas komennot;

    /**
     * Alustaa tekstikäyttöliittymän.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public TekstiKayttoliittyma(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
        this.komennot = new Komentotehdas(io, db);
    }

    @Override
    public void run() {
        io.tulostaRivi("Tervetuloa käyttämään BugTeXiä");
        komennot.hae("help").suorita();

        while (true) {
            if (!suoritaKomento()) {
                break;
            }

        }
    }

    private boolean suoritaKomento() {
        String rivi;
        try {
            rivi = io.lueRiviKysymyksella(">", "Anna komento:");
        } catch (NoSuchElementException ex) {
            return false;
        }

        if (rivi.equalsIgnoreCase("poistu") || rivi.equals("10")) {
            return false;
        }

        komennot.hae(rivi).suorita();
        return true;
    }

}
