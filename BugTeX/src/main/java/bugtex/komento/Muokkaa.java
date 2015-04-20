package bugtex.komento;

import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;

/**
 * Komento viitteen muokkaamiselle
 */
public class Muokkaa implements Komento {
    
    public final static String KOMENTO = "muokkaa";
    
    private final IO io;
    private final TietokantaRajapinta db;

    /**
     * Alustaa Muokkaa-komennon
     * 
     * @param io Käytettävä IO-luokka
     * @param db Käytettävä tietokanta-luokka
     */
    public Muokkaa(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
    }

    @Override
    public void suorita() {
        String tunnus = io.lueRiviKysymyksella(">", "viitteen tunnus?");
        Viite muokattava = db.haeTunnuksella(tunnus);
        
        if (muokattava == null) {
            io.tulostaRivi("Hakemaasi viitettä ei löytynyt!");
            return;
        }
        
        String kentta = kysyMuokattava(muokattava);
        if (kentta == null) {
            return;
        }
        
        String uusi = io.lueRiviKysymyksella(">", "Kentän uusi sisältö:");
        muokattava.getKyselyt().put(kentta, uusi);
        io.tulostaRivi("");
    }
    
    private String kysyMuokattava(Viite muokattava) {
        String[] rivit = muokattava.toString().split("\n");
        for (int i = 0; i < rivit.length; ++i) {
            io.tulostaRivi((i + 1) + ") " + rivit[i]);
        }
        
        io.tulostaRivi("");
        
        int kentta = io.lueNumeroKysymyksella(">", "Muokkaa kenttää numero:") - 1;
        if (kentta < 0 || kentta > rivit.length - 1) {
            io.tulostaRivi("Virheellinen kenttä!\n");
            return null;
        }
        
        return rivit[kentta].split(":")[0];
    }

}
