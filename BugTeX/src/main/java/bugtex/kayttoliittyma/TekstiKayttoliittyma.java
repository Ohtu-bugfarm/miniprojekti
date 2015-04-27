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

    /**
     * Alustaa tekstikäyttöliittymän.
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
        io.tulostaRivi("Tervetuloa käyttämään BugTeXiä");
        komennot.hae("help").suorita();

        while (true) {
            String rivi;
            try {
                rivi = io.lueRiviKysymyksella(">", "Anna komento:");
            } catch (NoSuchElementException ex) {
                break;
            }
            try {
                if (Integer.parseInt(rivi) == 10) {
                    break;
                }
            } catch (NumberFormatException e) {
                if (rivi.equalsIgnoreCase("poistu")) {
                    break;
                }
            }
            komennot.hae(rivi).suorita();
        }
    }
}
