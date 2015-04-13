package bugtex.viite;

import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KirjaTest {
    
    private Kirja kirja;
    
    @Before
    public void setUp() {
        this.kirja = new Kirja(1, "Kirjailija", "Kirja", "Julkaisija", "2015");
    }

    @Test
    public void toStringPalauttaaOikeinMaaranRiveja() {
        assertEquals(5, kirja.toString().split("\n").length);
    }
    
    @Test
    public void koodausMaarittaaOikeanMaaranKenttia() {
        assertEquals(4, kirja.koodaus().size());
    }
    
    @Test
    public void koodausMaarittaaKentatOikein() {
        Map<String, String> k = kirja.koodaus();
        assertEquals(kirja.getTekija(), k.get("author"));
        assertEquals(kirja.getNimi(), k.get("title"));
        assertEquals(kirja.getJulkaisija(), k.get("publisher"));
        assertEquals(kirja.getVuosi(), k.get("year"));
    }
    
}
