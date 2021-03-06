package bugtex.viite;

import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArtikkeliTest {

    private Artikkeli artikkeli;

    @Before
    public void setUp() {
        this.artikkeli = new Artikkeli("Tekija", "Artikkeli", "Julkaisu", "2015", "1");
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

    @Test
    public void tunnusMuodostuuOikein() {
        assertEquals("tekija2015artikkeli", artikkeli.getTunnus());
    }

    @Test
    public void josTunnusOnJoMaariteltySitaEiMuodostetaAutomaattisesti() {
        artikkeli.getKyselyt().put("tunnus", "1");
        assertEquals("1", artikkeli.getTunnus());
    }

}
