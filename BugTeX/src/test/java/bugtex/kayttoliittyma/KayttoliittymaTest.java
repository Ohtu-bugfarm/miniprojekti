package bugtex.kayttoliittyma;

import bugtex.IO.IO;
import bugtex.IO.Valelukija;
import bugtex.tietokanta.MuistiTietokanta;
import bugtex.tietokanta.TietokantaRajapinta;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class KayttoliittymaTest {
    
    Kayttoliittyma liittyma;
    
    @Before
    public void setUp() {
        IO lukija = new Valelukija(); 
        TietokantaRajapinta db = new MuistiTietokanta();
        liittyma = new TekstiKayttoliittyma(lukija, db);
    }
    
    @Test
    public void LiittymanLuontiOnnistuu() {
        assertEquals(TekstiKayttoliittyma.class, liittyma.getClass());
    }
}
