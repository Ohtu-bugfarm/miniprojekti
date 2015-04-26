package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;
import java.util.List;

/**
 * Komento viitteiden hakemiselle kenttien sisältöjen perusteella.
 */
class Hae implements Komento {

    public final static String KOMENTO = "hae";

    private final IO io;
    private final TietokantaRajapinta db;

    /**
     * Alustaa Hae-komennon.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Hae(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
    }

    @Override
    public void suorita() {
        List<Viite> haettava = db.annaViitteet();

        if (haettava.isEmpty()) {
            io.tulostaRivi("Viitteitä ei löytynyt\n");
        }

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
