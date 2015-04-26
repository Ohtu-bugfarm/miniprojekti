package bugtex.komento;

import bugtex.IO.IO;

/**
 * Aputekstin näyttävä komento.
 */
class Help implements Komento {

    public final static String KOMENTO = "help";

    private final IO io;

    /**
     * Alustaa Help-komennon.
     *
     * @param io Käytettävä IO-luokka
     */
    public Help(IO io) {
        this.io = io;
    }

    @Override
    public void suorita() {
        io.tulostaRivi("Ohjelma tuntee komennot lisaa(1), poista(2), hae(3), tarkastele(4), "
                     + "muokkaa(5), bibtex(6), listaa(7), listaaBibtex(8), generoiBibtex(9), "
                     + "poistu(10), help(11)\n");
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
