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
        int id = idgen.getId();
        System.out.println(id);
        Map<String, String> kyselyt = new TreeMap<>();
        String[] table = {"tekijä", "nimi", "julkaisija", "vuosi"};
        for (String kenttä : table) {
            String vastaus = io.lueRiviKysymyksella(">", kenttä);
            if (vastaus.equalsIgnoreCase("keskeytä")) {
                io.tulostaRivi("Keskeytettiin lisäys");
                return;
            }
            kyselyt.put(kenttä, vastaus);
        }       
       

        Viite viite = new Kirja(id, kyselyt.get("tekijä"), kyselyt.get("nimi"),
                          kyselyt.get("julkaisija"), kyselyt.get("vuosi"));
        if (db.lisaa(viite)) {
            io.tulostaRivi("Kirjan lisäys onnistui");
            io.tulostaRivi("Kirjan id on: " + id);
        } else {
            io.tulostaRivi("Lisäys ei onnistunut");
        }
    }

    @Override
    public String toString() {
        return KOMENTO;
    }

}
