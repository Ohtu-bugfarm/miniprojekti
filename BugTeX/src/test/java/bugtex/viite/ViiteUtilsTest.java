package bugtex.viite;

import org.junit.Test;
import static org.junit.Assert.*;

public class ViiteUtilsTest {

    public ViiteUtilsTest() {
    }

    @Test
    public void ensimmainenSanaPalauttaaOikeanTuloksenKunJakajanaVali() {
        assertEquals("eka", ViiteUtils.ensimmainenSana("eka toka kolmas", " "));
    }

    @Test
    public void ensimmainenSanaPalauttaaOikeanTuloksenKunJakajanaPilkku() {
        assertEquals("eka", ViiteUtils.ensimmainenSana("eka, toka, kolmas", ", "));
    }

    @Test
    public void ensimmainenSanaPalauttaaKokoMerkkijononJosJakajaEiEsiinny() {
        assertEquals("eka toka", ViiteUtils.ensimmainenSana("eka toka", "-"));
    }

}
