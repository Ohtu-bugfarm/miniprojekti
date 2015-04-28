package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;

/**
 * Komento viitteen muokkaamiselle.
 */
class Muokkaa extends Komento {

    public final static String KOMENTO = "muokkaa";

    /**
     * Alustaa Muokkaa-komennon.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Muokkaa(IO io, TietokantaRajapinta db) {
        super(io, db);
    }

    @Override
    public void suorita() {
        tulostaViitteidenTunnukset();
        int nro = io.lueNumeroKysymyksella(">", "muokattavan viitteen numero?");
        Viite muokattava = haeViiteNumerolla(nro);

        if (muokattava == null) {
            io.tulostaRivi("Hakemaasi viitettä ei löytynyt!\n");
            return;
        }

        String kentta = kysyMuokattava(muokattava);
        if (kentta != null) {
            kysyUusiSisalto(muokattava, kentta);
        }
    }

    private void tulostaVaihtoehdot(String[] rivit) {
        for (int i = 1; i <= rivit.length; ++i) {
            io.tulostaRivi(i + ") " + rivit[i - 1]);
        }
    }

    private String kysyMuokattava(Viite muokattava) {
        String[] rivit = muokattava.toString().split("\n");
        tulostaVaihtoehdot(rivit);

        io.tulostaRivi("");
        int kentta = io.lueNumeroKysymyksella(">", "Muokkaa kenttää numero:") - 1;
        if (kentta < 0 || kentta > rivit.length - 1) {
            io.tulostaRivi("Virheellinen kenttä!\n");
            return null;
        }

        return rivit[kentta].split(":")[0];
    }

    private void kysyUusiSisalto(Viite muokattava, String kentta) {
        String uusi = io.lueRiviKysymyksella(">", "Kentän uusi sisältö:");
        muokattava.getKyselyt().put(kentta, uusi);
        io.tulostaRivi("");

        if (!db.paivita()) {
            io.tulostaRivi("Virhe kirjoitettaessa tietokantaan");
        }
    }

}
