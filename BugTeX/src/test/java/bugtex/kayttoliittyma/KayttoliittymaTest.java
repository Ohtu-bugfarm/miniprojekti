package bugtex.kayttoliittyma;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class KayttoliittymaTest {
    
    Kayttoliittyma liittyma;
    
    @Before
    public void setUp() {
        liittyma = new TekstiKayttoliittyma();
    }
    
    @Test
    public void LiittymanLuontiOnnistuu() {
        assertEquals(TekstiKayttoliittyma.class, liittyma.getClass());
    }

}
