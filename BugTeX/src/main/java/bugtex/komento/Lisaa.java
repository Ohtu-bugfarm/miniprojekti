package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Artikkeli;
import bugtex.viite.Julkaisu;
import bugtex.viite.Kirja;
import bugtex.viite.Viite;
import bugtex.viite.Sekalainen;

import java.util.Map;
import java.util.TreeMap;

/**
 * Komento viitteen lisäämiselle.
 */
class Lisaa extends Komento {

    public final static String KOMENTO = "lisaa";

    /**
     * Alustaa lisää-komennon.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Lisaa(IO io, TietokantaRajapinta db) {
        super(io, db);
    }

    @Override
    public void suorita() {
        String tyyppi = io.lueRiviKysymyksella(">", "viitteen tyyppi? (kirja/artikkeli/julkaisu/sekalainen)");

        Viite lisattava = maaritaViitteenTyyppi(tyyppi);
        if (lisattava == null) {
            io.tulostaRivi("Virheellinen viitetyyppi\n");
            return;
        }

        lisaaTietokantaan(lisattava);
        io.tulostaRivi("");
    }

    private Viite maaritaViitteenTyyppi(String tyyppi) {
        switch (tyyppi) {
            case "kirja":
                return lisaaKirja();
            case "artikkeli":
                return lisaaArtikkeli();
            case "julkaisu":
                return lisaaJulkaisu();
            case "sekalainen":
                return lisaaSekalainen();
            default:
                return null;
        }
    }

    private void lisaaTietokantaan(Viite lisattava) {
        if (db.lisaa(lisattava)) {
            io.tulostaRivi("Viitteen lisäys onnistui");
            io.tulostaRivi("Viitteen tunnus on " + lisattava.getTunnus());
        } else {
            io.tulostaRivi("Lisäys ei onnistunut");
        }
    }

    private Map<String, String> kysyKentat(String[] kentat) {
        Map<String, String> kyselyt = new TreeMap<>();
        for (String kentta : kentat) {
            String vastaus = io.lueRiviKysymyksella(">", kentta + "?");

            if (vastaus.isEmpty()) {
                kyselyt.put(kentta, null);
            } else {
                kyselyt.put(kentta, vastaus);
            }
        }

        return kyselyt;
    }

    private Viite lisaaKirja() {
        Map<String, String> kyselyt = kysyKentat(Kirja.KENTAT);
        return new Kirja(kyselyt);
    }

    private Viite lisaaArtikkeli() {
        Map<String, String> kyselyt = kysyKentat(Artikkeli.KENTAT);
        return new Artikkeli(kyselyt);
    }

    private Viite lisaaJulkaisu() {
        Map<String, String> kyselyt = kysyKentat(Julkaisu.KENTAT);
        return new Julkaisu(kyselyt);
    }

    private Viite lisaaSekalainen() {
        Map<String, String> kyselyt = kysyKentat(Sekalainen.KENTAT);
        return new Sekalainen(kyselyt);
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
