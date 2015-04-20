package bugtex.tietokanta;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import bugtex.viite.Kirja;
import bugtex.viite.Viite;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TiedostoTietokantaTest {

    private TiedostoTietokanta db;
    private Viite kirja, kirja2;
    private List<Viite> kirjoja;

    @Before
    public void setUp() throws ClassNotFoundException {
        this.db = new TiedostoTietokanta("tiedosto");
        this.kirja = new Kirja(1, "Kirjailija", "Kirja", "Julkaisija", "2015");
        this.kirja2 = new Kirja(2, "Kirjailija2", "Kirja2", "Julkaisija2", "2015");
        kirjoja = new ArrayList<>();
        kirjoja.add(kirja);
        kirjoja.add(kirja2);
    }
    
    @Test
    public void tiedostoSyntyy() {
        assertTrue(db.tiedosto().exists());
    }
}
