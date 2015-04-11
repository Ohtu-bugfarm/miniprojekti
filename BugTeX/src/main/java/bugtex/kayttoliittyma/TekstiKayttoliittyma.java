package bugtex.kayttoliittyma;

import bugtex.komento.Komentotehdas;
import bugtex.lukija.Lukija;
import bugtex.tietokanta.TietokantaRajapinta;

public class TekstiKayttoliittyma implements Kayttoliittyma, Runnable {

    private final Lukija lukija;
    private final TietokantaRajapinta db;

    public TekstiKayttoliittyma(Lukija lukija, TietokantaRajapinta db) {
        this.lukija = lukija;
        this.db = db;
    }

    @Override
    public void run() {
        Komentotehdas komennot = new Komentotehdas(lukija, db);
        System.out.println("Tervetuloa käyttämään bugTexiä.");

        boolean running = true;
        while (running) {
            String syote = lukija.lueRiviKysymyksella(">", "Anna komento");
            if (syote.equals("Poistu")) {
                break;
            }
            komennot.hae(syote).suorita();
        }
    }

}
