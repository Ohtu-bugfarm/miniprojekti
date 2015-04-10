package bugtex.kayttoliittyma;

import bugtex.komento.Komentotehdas;
import bugtex.lukija.Syotteenlukija;

public class TekstiKayttoliittyma implements Kayttoliittyma, Runnable {

    private final Syotteenlukija lukija = new Syotteenlukija();

    public void run() {
        Komentotehdas komennot = new Komentotehdas(lukija);
        while (true) {
            komennot.hae(lukija.lueRivi(">")).suorita();
        }
    }

}
