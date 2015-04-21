package bugtex.komento;

import bugtex.IO.IO;

/**
 * Aputekstin näyttävä komento
 */
public class Help implements Komento {

    public final static String KOMENTO = "help";

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
        io.tulostaRivi("Ohjelma tuntee komennot lisaa, poista, tarkastele, muokkaa, bibtex, "
                + "listaa, listaaBibtex, generoiBibtex, poistu, help\n");
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
