package bugtex.komento;

import bugtex.lukija.Lukija;

public class Poista implements Komento {

    private final Lukija lukija;

    public Poista(Lukija lukija) {
        this.lukija = lukija;
    }

    @Override
    public void suorita() {
        System.out.println("Poistettiin jotakin");
    }
}
