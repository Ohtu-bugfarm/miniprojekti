package bugtex.komento;

import bugtex.IO.IO;

/**
 * Aputekstin näyttävä komento 
 */
public class Help implements Komento {

    public final static String KOMENTO = "Help";
    
    private final IO io;
    
    /**
     * Alustaa Help-komennon 
     * 
     * @param io Käytettävä IO-luokka
     */
    public Help(IO io) {
        this.io = io;
    }
    
    @Override
    public void suorita() {
        io.tulostaRivi("Ohjelma tuntee komennot Lisaa, Poista, Tarkastele, Bibtex, Listaa, Poistu, Help");
    }
    
    @Override
    public String toString() {
        return KOMENTO;
    }
    
}
