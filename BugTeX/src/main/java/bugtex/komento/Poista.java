package bugtex.komento;

import bugtex.lukija.Lukija;
import bugtex.tietokanta.TietokantaRajapinta;

public class Poista implements Komento {

    private final Lukija lukija;
    private final TietokantaRajapinta db;

    public Poista(Lukija lukija, TietokantaRajapinta db) {
        this.lukija = lukija;
        this.db = db;
    }

    @Override
    public void suorita() {
        System.out.println("Poistettiin jotakin");
    }
    
}
