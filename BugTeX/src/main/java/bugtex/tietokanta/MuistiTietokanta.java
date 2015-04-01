package bugtex.tietokanta;

import java.util.ArrayList;
import java.util.List;

import bugtex.viite.Viite;

/**
 * Viitteitä tallettava tietokanta, joka pidetään muistissa
 */
public class MuistiTietokanta implements TietokantaRajapinta {
    
    private final List<Viite> viitteet;
    
    /**
     * Luo uuden muistissa pidettävän tietokannan
     */
    public MuistiTietokanta() {
        this.viitteet = new ArrayList<>();
    }

    @Override
    public boolean lisaa(Viite viite) {
        this.viitteet.add(viite);
        return true;
    }

    @Override
    public Viite haeTunnuksella(int id) {
        for (Viite viite: this.viitteet) {
            if (viite.getID() == id) {
                return viite;
            }
        }
        
        return null;
    }

    @Override
    public boolean poistaTunnuksella(int id) {
        throw new UnsupportedOperationException("Ei toteutettu vielä");
    }
    
}
