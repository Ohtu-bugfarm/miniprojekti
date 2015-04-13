package bugtex.komento;

import bugtex.idgen.Generaattori;
import bugtex.idgen.IdGeneraattori;
import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Kirja;
import bugtex.viite.Viite;

/**
 * Komento viitteen lisäämiselle
 */
public class Lisaa implements Komento {

    public final static String KOMENTO = "Lisaa";
    
    private final IO io;
    private final Generaattori idgen;
    private final TietokantaRajapinta db;
    private Viite viite;

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
        String[] table = {"tekijä", "nimi", "julkaisija", "vuosi"};
        for (int i = 0; i < table.length; ++i) {
            table[i] = io.lueRiviKysymyksella(">", table[i]);
            if (table[i].equalsIgnoreCase("keskeyta")) {
                io.tulostaRivi("Keskeytettiin lisäys");
                return;
            }
        }
        
        viite = new Kirja(id, table[0], table[1], table[2], table[3]);
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
