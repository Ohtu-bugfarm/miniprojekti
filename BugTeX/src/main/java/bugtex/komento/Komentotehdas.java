package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;

import java.util.HashMap;

/**
 * Luokka ohjelmien komentojen hakemiselle.
 */
public final class Komentotehdas {

    private final HashMap<String, Komento> komennot;
    private final HashMap<Integer, Komento> numeroKomennot;

    /**
     * Alustaa komentotehtaan.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Komentotehdas(IO io, TietokantaRajapinta db) {
        this.komennot = new HashMap<>();
        this.numeroKomennot = new HashMap<>();
        luoTavallisetKomennot(io, db);
        luoNumeroKomennot(io, db);
    }

    private void luoTavallisetKomennot(IO io, TietokantaRajapinta db) {
        komennot.put(GeneroiBibtexTiedosto.KOMENTO, new GeneroiBibtexTiedosto(io, db));
        komennot.put(Lisaa.KOMENTO, new Lisaa(io, db));
        komennot.put(Poista.KOMENTO, new Poista(io, db));
        komennot.put(Tarkastele.KOMENTO, new Tarkastele(io, db));
        komennot.put(TarkasteleBibtex.KOMENTO, new TarkasteleBibtex(io, db));
        komennot.put(Help.KOMENTO, new Help(io));
        komennot.put(Listaa.KOMENTO, new Listaa(io, db));
        komennot.put(Muokkaa.KOMENTO, new Muokkaa(io, db));
        komennot.put(ListaaBibtex.KOMENTO, new ListaaBibtex(io, db));
        komennot.put(Hae.KOMENTO, new Hae(io, db));
    }

    private void luoNumeroKomennot(IO io, TietokantaRajapinta db) {
        numeroKomennot.put(9, new GeneroiBibtexTiedosto(io, db));
        numeroKomennot.put(1, new Lisaa(io, db));
        numeroKomennot.put(2, new Poista(io, db));
        numeroKomennot.put(4, new Tarkastele(io, db));
        numeroKomennot.put(6, new TarkasteleBibtex(io, db));
        numeroKomennot.put(11, new Help(io));
        numeroKomennot.put(7, new Listaa(io, db));
        numeroKomennot.put(5, new Muokkaa(io, db));
        numeroKomennot.put(8, new ListaaBibtex(io, db));
        numeroKomennot.put(3, new Hae(io, db));
    }

    /**
     * Hae komennon nimeä vastaava komentoluokka.
     *
     * @param syote komennon nimi
     * @return komentoa vastaava luokka
     */
    public Komento hae(String syote) {
        try {
            return haeNumeroKomento(syote);
        } catch (NumberFormatException e) {
            return haeTavallinenKomento(syote);
        }
    }

    private Komento haeNumeroKomento(String syote) {
        int luku = Integer.parseInt(syote);
        Komento komento = numeroKomennot.get(luku);

        if (komento == null) {
            komento = numeroKomennot.get(11);
        }

        return komento;
    }

    private Komento haeTavallinenKomento(String syote) {
        String operaatio = syote.toLowerCase().trim();
        Komento komento = komennot.get(operaatio);

        if (komento == null) {
            komento = komennot.get("help");
        }

        return komento;
    }

}
