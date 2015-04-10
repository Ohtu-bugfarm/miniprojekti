package bugtex.komento;

import bugtex.lukija.Syotteenlukija;
import java.util.HashMap;

public class Komentotehdas {

    private HashMap<String, Komento> komennot;

    public Komentotehdas(Syotteenlukija lukija) {
        this.komennot = new HashMap<String, Komento>();
        komennot.put("Lisaa", new Lisaa(lukija));
        komennot.put("Poista", new Poista(lukija));
        komennot.put("Poistu", new Poistu());
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
