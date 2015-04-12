package bugtex.kayttoliittyma;

import bugtex.komento.Komentotehdas;
import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import java.util.NoSuchElementException;

public class TekstiKayttoliittyma implements Kayttoliittyma, Runnable {

    private final IO io;
    private final TietokantaRajapinta db;

    public TekstiKayttoliittyma(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
    }

    @Override
    public void run() {

        Komentotehdas komennot = new Komentotehdas(io, db);
        io.tulostaRivi("Tervetuloa käyttämään bugTexiä.");

        while (true) {
            try {
                komennot.hae(io.lueRiviKysymyksella(">", "Anna komento")).suorita();
            } catch (NoSuchElementException ex) {
                break;
            }
        }
    }

}
