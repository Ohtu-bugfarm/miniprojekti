package bugtex.kayttoliittyma;

import bugtex.komento.Komentotehdas;
import bugtex.lukija.Lukija;
import bugtex.tietokanta.TietokantaRajapinta;

public class TekstiKayttoliittyma implements Kayttoliittyma, Runnable {

    private final Lukija lukija;
    private final TietokantaRajapinta db;
    
    public TekstiKayttoliittyma(Lukija lukija, TietokantaRajapinta db){
        this.lukija = lukija;
        this.db = db;
    }
    
    @Override
    public void run() {
        Komentotehdas komennot = new Komentotehdas(lukija, db);
        System.out.println("Tervetuloa käyttämään bugTexiä.");
        
        while (true) {
            komennot.hae(lukija.lueRiviKysymyksella(">", "Anna komento")).suorita();
        }
    }

}
