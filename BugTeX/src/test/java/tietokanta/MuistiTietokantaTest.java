package tietokanta;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import viite.Kirja;
import viite.Viite;

public class MuistiTietokantaTest {
    
    private MuistiTietokanta db;
    private Viite kirja;
    
    @Before
    public void setUp() {      
        this.db = new MuistiTietokanta();
        this.kirja = new Kirja(1, "Kirjailija", "Kirja", "Julkaisija", 2015);
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
    
}
