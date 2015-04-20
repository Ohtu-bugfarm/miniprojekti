package bugtex.komento;

import bugtex.IO.IO;
import bugtex.IO.Valelukija;
import bugtex.tietokanta.MuistiTietokanta;
import bugtex.tietokanta.TietokantaRajapinta;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class KomentotehdasTest {
    
    private Komentotehdas komennot;
    
    public KomentotehdasTest() {
    }

    @Before
    public void setUp() {
        IO lukija = new Valelukija(); 
        TietokantaRajapinta db = new MuistiTietokanta();
        komennot = new Komentotehdas(lukija, db);
    }
    
    @Test
    public void loytaaOlemassaOlevanKomennon() {
        assertEquals(Lisaa.KOMENTO, komennot.hae("Lisaa").toString());
    }
    
    @Test
    public void virheellinenKomentoPalauttaaHelpKomennon() {
        assertEquals(Help.KOMENTO, komennot.hae("abcd").toString());
    }
    
}
