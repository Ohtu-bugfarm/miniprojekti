package bugtex.tietokanta;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import bugtex.viite.Kirja;
import bugtex.viite.Viite;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;

public class TiedostoTietokantaTest {

    private TiedostoTietokanta db, tyhjaDB;
    private Viite kirja, kirja2;
    private List<Viite> kirjoja;

    @Before
    public void setUp() throws ClassNotFoundException, IOException {
        this.db = new TiedostoTietokanta("src/test/resources/test.txt");
        this.tyhjaDB = new TiedostoTietokanta("src/test/resources/tyhja.txt");
        this.kirja = new Kirja("Kirjailija", "Kirja", "Julkaisija", "2015");
        this.kirja2 = new Kirja("Kirjailija2", "Kirja2", "Julkaisija2", "2015");
        kirjoja = new ArrayList<>();
        kirjoja.add(kirja);
        kirjoja.add(kirja2);
    }

    @After
    public void tearDown() {
        db.tiedosto().delete();
        tyhjaDB.tiedosto().delete();
    }

    @Test
    public void tiedostoSyntyy() {
        assertTrue(db.tiedosto().exists());
    }

    @Test
    public void tyhjaTiedostoPalauttaaTyhjanListan() {
        assertTrue(tyhjaDB.annaViitteet().isEmpty());
    }

    @Test
    public void epatyhjaTiedostoPalauttaaEpatyhjanListan() {
        tyhjaDB.lisaa(kirja);
        TiedostoTietokanta s = null;
        try {
            s = new TiedostoTietokanta(tyhjaDB.tiedosto().getAbsolutePath());
        } catch (ClassNotFoundException ex) {
            fail();
        }

        assertNotNull(s);
        assertEquals(1, s.annaViitteet().size());
    }

    @Test
    public void tiedostoaVoiLukeaJaKirjoittaa() {
        assertTrue(db.tiedosto().canRead());
        assertTrue(db.tiedosto().canWrite());
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
        assertNull(db.haeTunnuksella("kirjailija2015kirja"));
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
    public void poistaaViitteen() {
        db.lisaa(kirja);
        assertTrue(db.poistaTunnuksella(kirja.getTunnus()));
    }

    @Test
    public void poistaminenEiPaivitaTietokantaaJosPoistettavaaViitettaEiOle() {
        assertFalse(tyhjaDB.poistaTunnuksella(kirja.getTunnus()));
    }

}
