package bugtex.tietokanta;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import bugtex.viite.Kirja;
import bugtex.viite.Viite;
import java.util.ArrayList;
import java.util.List;

public class MuistiTietokantaTest {

    private MuistiTietokanta db;
    private Viite kirja, kirja2;
    private List<Viite> kirjoja;

    @Before
    public void setUp() {
        this.db = new MuistiTietokanta();
        this.kirja = new Kirja("Kirjailija", "Kirja", "Julkaisija", "2015");
        this.kirja2 = new Kirja("Kirjailija2", "Kirja2", "Julkaisija2", "2015");
        kirjoja = new ArrayList<>();
        kirjoja.add(kirja);
        kirjoja.add(kirja2);
    }

    @Test
    public void lisaysOnnistuu() {
        assertTrue(db.lisaa(kirja));
    }

    @Test
    public void hakuLoytaaOlemassaOlevanViitteen() {
        db.lisaa(kirja);
        assertEquals(kirja, db.haeTunnuksella("kirjailija2015kirja"));
    }

    @Test
    public void hakuLoytaaOikeanViitteen() {
        db.lisaa(kirja);
        db.lisaa(kirja2);
        assertEquals(kirja2, db.haeTunnuksella("kirjailija22015kirja2"));
    }

    @Test
    public void hakuEiLoydaOlematontaViitetta() {
        assertNull(db.haeTunnuksella("1"));
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

    @Test
    public void antaaOikeanViitteenKunOnYksiViite() {
        db.lisaa(kirja);
        assertTrue(db.annaViitteet().get(0).equals(kirja));
    }

    @Test
    public void antaaOikeatViitteet() {
        for (Viite viite : kirjoja) {
            db.lisaa(viite);
        }

        List<Viite> tulokset = db.annaViitteet();
        assertTrue(tulokset.containsAll(kirjoja));
    }
    
    @Test
    public void poistaminenOnnistuuKunViiteOnTietokannssa() {
        db.lisaa(kirja);
        assertTrue(db.poistaTunnuksella(kirja.getTunnus()));
        assertFalse(db.annaViitteet().contains(kirja));
    }
    
    @Test
    public void poistaminenEpaonnistuuKunViiteEiOleTietokannassa() {
        assertFalse(db.poistaTunnuksella(kirja.getTunnus()));
    }

}
