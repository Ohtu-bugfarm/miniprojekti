package bugtex.kayttoliittyma;

import bugtex.lukija.Lukija;
import bugtex.lukija.Valelukija;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class KayttoliittymaTest {
    
    Kayttoliittyma liittyma;
    
    @Before
    public void setUp() {
        Lukija lukija = new Valelukija(); 
        liittyma = new TekstiKayttoliittyma(lukija);
    }
    
    @Test
    public void LiittymanLuontiOnnistuu() {
        assertEquals(TekstiKayttoliittyma.class, liittyma.getClass());
    }

}
