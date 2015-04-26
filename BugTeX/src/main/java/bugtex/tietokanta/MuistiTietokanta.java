package bugtex.tietokanta;

import java.util.ArrayList;
import java.util.List;

import bugtex.viite.Viite;

/**
 * Viitteitä tallettava tietokanta, joka pidetään muistissa.
 */
public class MuistiTietokanta implements TietokantaRajapinta {

    private final List<Viite> viitteet;

    /**
     * Luo uuden muistissa pidettävän tietokannan.
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
    public Viite haeTunnuksella(String tunnus) {
        for (Viite viite: this.viitteet) {
            if (viite.getTunnus() != null && viite.getTunnus().equals(tunnus)) {
                return viite;
            }
        }

        return null;
    }

    @Override
    public boolean poistaTunnuksella(String tunnus) {
        Viite viite = haeTunnuksella(tunnus);
        return viitteet.remove(viite);
    }

    @Override
    public List<Viite> annaViitteet() {
        return this.viitteet;
    }

    @Override
    public boolean paivita() {
        return true;
    }

}
