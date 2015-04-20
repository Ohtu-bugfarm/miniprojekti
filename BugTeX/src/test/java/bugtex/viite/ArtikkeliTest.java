package bugtex.viite;

import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArtikkeliTest {
    
    private Artikkeli artikkeli;
    
    @Before
    public void setUp() {
        this.artikkeli = new Artikkeli("1", "Tekija", "Artikkeli", "Julkaisu", "2015", "1");
    }

    @Test
    public void toStringPalauttaaOikeinMaaranRiveja() {
        assertEquals(6, artikkeli.toString().split("\n").length);
    }
    
    @Test
    public void koodausMaarittaaOikeanMaaranKenttia() {
        assertEquals(5, artikkeli.koodaus().size());
    }
    
    @Test
    public void koodausMaarittaaKentatOikein() {
        Map<String, String> k = artikkeli.koodaus();
        assertEquals(artikkeli.getTekija(), k.get("author"));
        assertEquals(artikkeli.getNimi(), k.get("title"));
        assertEquals(artikkeli.getLehti(), k.get("journal"));
        assertEquals(artikkeli.getVuosi(), k.get("year"));
        assertEquals(artikkeli.getNide(), k.get("volume"));
    }
    
}
