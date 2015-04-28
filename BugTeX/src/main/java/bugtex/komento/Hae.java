package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;
import java.util.List;

/**
 * Komento viitteiden hakemiselle kenttien sisältöjen perusteella.
 */
class Hae extends Komento {

    public final static String KOMENTO = "hae";

    /**
     * Alustaa Hae-komennon.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Hae(IO io, TietokantaRajapinta db) {
        super(io, db);
    }

    @Override
    public void suorita() {
        List<Viite> haettava = db.annaViitteet();
        String kentta = io.lueRiviKysymyksella(">", "haettava kenttä?");
        String etsittava = io.lueRiviKysymyksella(">", "kentän sisältö?");

        for (Viite viite : haettava) {
            if (viitteenKenttaTasmaa(viite, kentta, etsittava)) {
                io.tulostaRivi(viite.toString());
            }
        }
    }

    private boolean viitteenKenttaTasmaa(Viite viite, String kentta, String etsittava) {
        String kentanSisalto = viite.getKyselyt().get(kentta);
        if (kentanSisalto == null) {
            return false;
        }

        return kentanSisalto.contains(etsittava);
    }

}
