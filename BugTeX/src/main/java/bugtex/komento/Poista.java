package bugtex.komento;

import bugtex.lukija.Syotteenlukija;

public class Poista implements Komento {

    private Syotteenlukija lukija;

    public Poista(Syotteenlukija lukija) {
        this.lukija = lukija;
    }

    @Override
    public void suorita() {
        System.out.println("Poistettiin tyhmä");
    }
}
