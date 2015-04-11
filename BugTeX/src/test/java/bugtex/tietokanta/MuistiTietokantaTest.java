package bugtex.tietokanta;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import bugtex.viite.Kirja;
import bugtex.viite.Viite;

public class MuistiTietokantaTest {
    
    private MuistiTietokanta db;
    private Viite kirja;
    
    @Before
    public void setUp() {      
        this.db = new MuistiTietokanta();
        this.kirja = new Kirja(1, "Kirjailija", "Kirja", "Julkaisija", "2015");
    }

    @Test
    public void lisaysOnnistuu() {
        assertTrue(db.lisaa(kirja));
    }
    
    @Test
    public void hakuLoytaaOlemassaOlevanViitteen() {
        db.lisaa(kirja);
        assertEquals(kirja, db.haeTunnuksella(1));
    }
    
    @Test
    public void hakuEiLoydaOlematontaViitetta() {
        assertNull(db.haeTunnuksella(2));
    }
    
    @Test
    public void antaaOikeanMaaranViitteitaKunViitteitaEiOle() {
        assertEquals(0, db.annaViitteet().size());
    }
    
    @Test
    public void antaaOikeanMaaranViitteitaKunOnYksiViite() {
        db.lisaa(kirja);
        assertEquals(1, db.annaViitteet().size());
    }
    
}
