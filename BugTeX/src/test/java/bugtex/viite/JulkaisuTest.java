package bugtex.viite;

import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JulkaisuTest {

    private Julkaisu julkaisu;

    @Before
    public void setUp() {
        this.julkaisu = new Julkaisu("Tekija", "Nimi", "Kirjannimi", "2015");
    }

    @Test
    public void toStringPalauttaaOikeinMaaranRiveja() {
        assertEquals(5, julkaisu.toString().split("\n").length);
    }

    @Test
    public void koodausMaarittaaOikeanMaaranKenttia() {
        assertEquals(4, julkaisu.koodaus().size());
    }

    @Test
    public void koodausMaarittaaKentatOikein() {
        Map<String, String> k = julkaisu.koodaus();
        assertEquals(julkaisu.getTekija(), k.get("author"));
        assertEquals(julkaisu.getNimi(), k.get("title"));
        assertEquals(julkaisu.getKirjanNimi(), k.get("booktitle"));
        assertEquals(julkaisu.getVuosi(), k.get("year"));
    }

    @Test
    public void tunnusMuodostuuOikein() {
        assertEquals("tekija2015nimi", julkaisu.getTunnus());
    }

    @Test
    public void josTunnusOnJoMaariteltySitaEiMuodostetaAutomaattisesti() {
        julkaisu.getKyselyt().put("tunnus", "1");
        assertEquals("1", julkaisu.getTunnus());
    }

}
