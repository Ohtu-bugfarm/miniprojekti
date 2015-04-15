package bugtex.komento;

import bugtex.idgen.Generaattori;
import bugtex.idgen.IdGeneraattori;
import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Kirja;
import bugtex.viite.Viite;
import java.util.Map;
import java.util.TreeMap;

/**
 * Komento viitteen lisäämiselle
 */
public class Lisaa implements Komento {

    public final static String KOMENTO = "Lisaa";

    private final IO io;
    private final Generaattori idgen;
    private final TietokantaRajapinta db;

    /**
     * Alustaa lisää-komennon
     *
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Lisaa(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
        this.idgen = new IdGeneraattori();
    }

    @Override
    public void suorita() {
        String tyyppi = io.lueRiviKysymyksella(">", "viitteen tyyppi? (kirja/artikkeli)");
        
        Viite viite;
        switch (tyyppi) {
            case "kirja":
                viite = lisaaKirja();
                break;
            case "artikkeli":
                viite = lisaaArtikkeli();
                break;
            default:
                io.tulostaRivi("virheellinen viitetyyppi");
                return;
        }
        
        if (viite == null) {
            return;
        }
        
        if (db.lisaa(viite)) {
            io.tulostaRivi("Viitteen lisäys onnistui");
            io.tulostaRivi("Viitteen id on: " + viite.getID());
        } else {
            io.tulostaRivi("Lisäys ei onnistunut");
        }
    }
    
    private Map<String, String> kysyKentat(String[] kentat) {
        Map<String, String> kyselyt = new TreeMap<>();
        for (String kentta : kentat) {
            String vastaus = io.lueRiviKysymyksella(">", kentta);
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
        
        int id = idgen.getId();
        return new Kirja(id, kyselyt);
    }
    
    private Viite lisaaArtikkeli() {
        return null;
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
