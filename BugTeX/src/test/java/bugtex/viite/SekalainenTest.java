
package bugtex.viite;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class SekalainenTest {
    
    private Sekalainen misc;
    
        
    @Before
    public void setUp() {
        this.misc = new Sekalainen("Tekija", "Nimi", "Julkaisutyyppi", "Tammikuu", "2015", "huomio");
    }
    
    @Test
    public void toStringPalauttaaOikeinMaaranRiveja() {
        assertEquals(7, misc.toString().split("\n").length);
    }
    
    @Test
    public void koodausMaarittaaOikeanMaaranKenttia() {
        assertEquals(6, misc.koodaus().size());
    }
    
    @Test
    public void koodausMaarittaaKentatOikein() {
        Map<String, String> k = misc.koodaus();
        assertEquals(misc.getTekija(), k.get("author"));
        assertEquals(misc.getNimi(), k.get("title"));
        assertEquals(misc.getJulkaisutyyppi(), k.get("howpublished"));
        assertEquals(misc.getKuukausi(), k.get("month"));
        assertEquals(misc.getVuosi(), k.get("year"));
        assertEquals(misc.getHuomautus(), k.get("note"));
    }
}
