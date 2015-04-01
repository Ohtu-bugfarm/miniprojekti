package bugtex.viite;

import bugtex.viite.Kirja;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KirjaTest {
    
    private Kirja kirja;
    
    @Before
    public void setUp() {
        this.kirja = new Kirja(1, "Kirjailija", "Kirja", "Julkaisija", 2015);
    }

    @Test
    public void toStringPalauttaaOikeinMaaranRiveja() {
        assertEquals(5, kirja.toString().split("\n").length);
    }
    
}
