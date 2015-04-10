package bugtex.komento;

import bugtex.lukija.Syotteenlukija;

public class Tuntemattomat implements Komento {

    private Syotteenlukija lukija;

    public Tuntemattomat(Syotteenlukija lukija) {
        this.lukija = lukija;
    }

    @Override
    public void suorita() {
        System.out.println("Ohjelma tuntee komennot Lisaa,Poista, Poistu, Help");
    }
}
