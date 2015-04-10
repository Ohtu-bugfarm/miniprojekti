package bugtex.komento;

import bugtex.lukija.Syotteenlukija;

public class Lisaa implements Komento {

    private Syotteenlukija lukija;

    public Lisaa(Syotteenlukija lukija) {
        this.lukija = lukija;
    }

    @Override
    public void suorita() {
        System.out.println("Lisattiin tyhma");
    }

}
