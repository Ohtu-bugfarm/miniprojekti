package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;

import java.util.HashMap;

/**
 * Luokka ohjelmien komentojen hakemiselle
 */
public class Komentotehdas {

    private HashMap<String, Komento> komennot;

    /**
     * Alustaa komentotehtaan
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Komentotehdas(IO io, TietokantaRajapinta db) {
        this.komennot = new HashMap<String, Komento>();

        komennot.put(Lisaa.KOMENTO, new Lisaa(io, db));
        komennot.put(Poista.KOMENTO, new Poista(io, db));
        komennot.put(Tarkastele.KOMENTO, new Tarkastele(io, db));
        komennot.put(Help.KOMENTO, new Help(io));
        komennot.put(Poistu.KOMENTO, new Poistu());
        komennot.put(Listaa.KOMENTO, new Listaa(io, db));

    }

    private String luoOperaatio(String syote) {
        syote = syote.toLowerCase();
        String ekamerkki = "";
        ekamerkki += syote.charAt(0);
        ekamerkki = ekamerkki.toUpperCase();
        syote = ekamerkki + syote.substring(1, syote.length());
        return syote;
    }

    /**
     * Hae komennon nimeä vastaava komentoluokka
     *
     * @param syote komennon nimi
     * @return komentoa vastaava luokka
     */
    public Komento hae(String syote) {
        String operaatio = luoOperaatio(syote);
        Komento komento = komennot.get(operaatio);
        if (komento == null) {
            komento = komennot.get("Help");
        }

        return komento;
    }

}
