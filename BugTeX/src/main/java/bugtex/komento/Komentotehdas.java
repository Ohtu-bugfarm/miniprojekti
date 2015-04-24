package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;

import java.util.HashMap;

/**
 * Luokka ohjelmien komentojen hakemiselle.
 */
public final class Komentotehdas {

    private HashMap<String, Komento> komennot;

    /**
     * Alustaa komentotehtaan.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Komentotehdas(IO io, TietokantaRajapinta db) {
        this.komennot = new HashMap<String, Komento>();
        komennot.put(GeneroiBibtexTiedosto.KOMENTO, new GeneroiBibtexTiedosto(io, db));
        komennot.put(Lisaa.KOMENTO, new Lisaa(io, db));
        komennot.put(Poista.KOMENTO, new Poista(io, db));
        komennot.put(Tarkastele.KOMENTO, new Tarkastele(io, db));
        komennot.put(TarkasteleBibtex.KOMENTO, new TarkasteleBibtex(io, db));
        komennot.put(Help.KOMENTO, new Help(io));
        komennot.put(Listaa.KOMENTO, new Listaa(io, db));
        komennot.put(Muokkaa.KOMENTO, new Muokkaa(io, db));
        komennot.put(ListaaBibtex.KOMENTO, new ListaaBibtex(io, db));
    }

    /**
     * Hae komennon nimeä vastaava komentoluokka.
     *
     * @param syote komennon nimi
     * @return komentoa vastaava luokka
     */
    public Komento hae(String syote) {
        String operaatio = syote.toLowerCase();
        Komento komento = komennot.get(operaatio);

        if (komento == null) {
            komento = komennot.get("help");
        }

        return komento;
    }

}
