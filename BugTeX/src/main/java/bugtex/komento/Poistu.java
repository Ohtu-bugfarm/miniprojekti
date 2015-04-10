package bugtex.komento;

import bugtex.lukija.Syotteenlukija;

public class Poistu implements Komento {

    private Syotteenlukija lukija;
    
    public Poistu(Syotteenlukija lukija) {
        this.lukija = lukija;
    }
    
    @Override
    public void suorita() {
        System.exit(0);
    }    
}
