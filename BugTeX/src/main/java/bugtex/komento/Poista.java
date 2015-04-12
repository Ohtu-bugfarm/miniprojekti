package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;

public class Poista implements Komento {

    private final IO io;
    private final TietokantaRajapinta db;

    public Poista(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
    }

    @Override
    public void suorita() {
        io.tulostaRivi("Poistettiin jotakin");
    }
    
}
