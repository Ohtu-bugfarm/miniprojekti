package bugtex.komento;

import bugtex.IO.IO;

public class Tuntemattomat implements Komento {

    private final IO io;
    
    public Tuntemattomat(IO io) {
        this.io = io;
    }
    
    @Override
    public void suorita() {
        io.tulostaRivi("Ohjelma tuntee komennot Lisaa, Poista, Tarkastele, Poistu, Help");
    }
    
}
