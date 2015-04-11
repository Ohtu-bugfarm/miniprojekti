package bugtex.kayttoliittyma;

import bugtex.komento.Komentotehdas;
import bugtex.lukija.Lukija;

public class TekstiKayttoliittyma implements Kayttoliittyma, Runnable {

    private Lukija lukija;
    
    public TekstiKayttoliittyma(Lukija lukija){
        this.lukija = lukija;
    }
    
    @Override
    public void run() {
        Komentotehdas komennot = new Komentotehdas(lukija);
        System.out.println("Tervetuloa käyttämään bugTexiä.");
        
        while (true) {
            komennot.hae(lukija.lueRiviKysymyksella(">", "Anna komento")).suorita();
        }
    }

}
