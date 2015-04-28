package bugtex.komento;

import bugtex.IO.IO;

/**
 * Aputekstin näyttävä komento.
 */
class Help extends Komento {

    public final static String KOMENTO = "help";

    private final String[] komennot = {
        Lisaa.KOMENTO,
        Poista.KOMENTO,
        Hae.KOMENTO,
        Tarkastele.KOMENTO,
        Muokkaa.KOMENTO,
        TarkasteleBibtex.KOMENTO,
        Listaa.KOMENTO,
        ListaaBibtex.KOMENTO,
        GeneroiBibtexTiedosto.KOMENTO,
        "poistu",
        Help.KOMENTO
    };

    /**
     * Alustaa Help-komennon.
     *
     * @param io Käytettävä IO-luokka
     */
    public Help(IO io) {
        super(io);
    }

    @Override
    public void suorita() {
        io.tulostaRivi("Ohjelma tuntee komennot:");

        for (int i = 1; i <= komennot.length; ++i) {
            io.tulostaRivi(i + ") " + komennot[i - 1]);
        }

        io.tulostaRivi("");
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
