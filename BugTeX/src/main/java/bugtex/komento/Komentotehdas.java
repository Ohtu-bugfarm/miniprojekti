package bugtex.komento;

import java.util.HashMap;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;

public class Komentotehdas {

    private HashMap<String, Komento> komennot;

    public Komentotehdas(IO io, TietokantaRajapinta db) {
        this.komennot = new HashMap<String, Komento>();

        komennot.put("Lisaa", new Lisaa(io, db));
        komennot.put("Poista", new Poista(io, db));
        komennot.put("Poistu", new Poistu());
        komennot.put("Help", new Tuntemattomat(io));

    }

    public Komento hae(String operaatio) {
        Komento komento = komennot.get(operaatio);
        if (komento == null) {
            komento = komennot.get("Help");
        }
        return komento;
    }
}
