package bugtex.IO;

import java.util.NoSuchElementException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ValelukijaTest {

    private Valelukija lukija, tyhja;

    public ValelukijaTest() {

    }

    @Before
    public void setUp() {
        lukija = new Valelukija("a", "b", "c", "2");
        tyhja = new Valelukija();
    }

    @Test(expected = NoSuchElementException.class)
    public void syotteenLoppuminenAiheuttaaExceptionin() {
        tyhja.lueRivi("");
    }

    @Test
    public void syotteenEnsimmaisenElementinLukeminenOnnistuu() {
        assertEquals("a", lukija.lueRivi(""));
    }

    @Test
    public void numeroSyotteenLukuOnnistuu() {
        lukija.lueRivi("");
        lukija.lueRivi("");
        lukija.lueRivi("");
        assertEquals(2, lukija.lueNumeroKysymyksella("", ""));
    }

    @Test
    public void syotteenViimeisenElementinLukeminenOnnistuu() {
        lukija.lueRivi("");
        lukija.lueRivi("");
        assertEquals("c", lukija.lueRivi(""));
    }

    @Test
    public void ennenTulostamistaTulosteetOnTyhja() {
        assertEquals(0, tyhja.getTulostukset().size());
    }

    @Test
    public void tulostamisenJalkeenTulosteissaOnYksiElementti() {
        tyhja.tulostaRivi("a");
        assertEquals(1, tyhja.getTulostukset().size());
    }

    @Test
    public void tulostamisenJalkeenTulostettuElementtiOnTulosteissa() {
        tyhja.tulostaRivi("b");
        assertEquals("b", tyhja.getTulostukset().get(0));
    }

}
