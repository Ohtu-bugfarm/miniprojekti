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
public class Lisaa implements Komento {

    public final static String KOMENTO = "lisaa";

    private final IO io;
    private final TietokantaRajapinta db;

    /**
     * Alustaa lisää-komennon.
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Lisaa(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
    }

    @Override
    public void suorita() {
        String tyyppi = io.lueRiviKysymyksella(">", "viitteen tyyppi? (kirja/artikkeli/julkaisu/sekalainen)");

        Viite viite;
        switch (tyyppi) {
            case "kirja":
                viite = lisaaKirja();
                break;
            case "artikkeli":
                viite = lisaaArtikkeli();
                break;
            case "julkaisu":
                viite = lisaaJulkaisu();
                break;
            case "sekalainen":
                viite = lisaaSekalainen();
                break;
            default:
                io.tulostaRivi("Virheellinen viitetyyppi\n");
                return;
        }

        if (viite == null) {
            return;
        }

        if (db.lisaa(viite)) {
            io.tulostaRivi("Viitteen lisäys onnistui");
            io.tulostaRivi("Viitteen tunnus on " + viite.getTunnus());
        } else {
            io.tulostaRivi("Lisäys ei onnistunut");
        }

        io.tulostaRivi("");
    }

    private Map<String, String> kysyKentat(String[] kentat) {
        Map<String, String> kyselyt = new TreeMap<>();
        for (String kentta : kentat) {
            String vastaus = io.lueRiviKysymyksella(">", kentta + "?");
            if (vastaus.equalsIgnoreCase("keskeyta")) {
                io.tulostaRivi("Keskeytettiin lisäys");
                return null;
            }

            if (vastaus.isEmpty()) {
                kyselyt.put(kentta, null);
            } else {
                kyselyt.put(kentta, vastaus);
            }
        }

        return kyselyt;
    }

    private Viite lisaaKirja() {
        Map<String, String> kyselyt = kysyKentat(Kirja.getKentat());
        if (kyselyt == null) {
            return null;
        }

        return new Kirja(kyselyt);
    }

    private Viite lisaaArtikkeli() {
        Map<String, String> kyselyt = kysyKentat(Artikkeli.getKentat());
        if (kyselyt == null) {
            return null;
        }

        return new Artikkeli(kyselyt);
    }

    private Viite lisaaJulkaisu() {
        Map<String, String> kyselyt = kysyKentat(Julkaisu.getKentat());
        if (kyselyt == null) {
            return null;
        }

        return new Julkaisu(kyselyt);
    }
    
    private Viite lisaaSekalainen() {
        Map<String, String> kyselyt = kysyKentat(Sekalainen.getKentat());
        if (kyselyt == null) {
            return null;
        }

        return new Sekalainen(kyselyt);
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
