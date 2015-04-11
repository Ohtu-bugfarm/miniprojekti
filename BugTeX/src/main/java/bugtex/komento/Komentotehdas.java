package bugtex.komento;

import java.util.HashMap;

import bugtex.lukija.Lukija;
import bugtex.tietokanta.TietokantaRajapinta;

public class Komentotehdas {

    private HashMap<String, Komento> komennot;

    public Komentotehdas(Lukija lukija, TietokantaRajapinta db) {
        this.komennot = new HashMap<String, Komento>();
        komennot.put("Lisaa", new Lisaa(lukija, db));
        komennot.put("Poista", new Poista(lukija, db));
        komennot.put("Help", new Tuntemattomat());
    }

    public Komento hae(String operaatio) {
        Komento komento = komennot.get(operaatio);
        if (komento == null) {
            komento = komennot.get("Help");
        }
        return komento;
    }
}
