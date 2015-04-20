package bugtex.bibtex;

import bugtex.viite.Kirja;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BibTeXMuotoilijaTest {
    
    private Kirja kirja;
    
    public BibTeXMuotoilijaTest() {
    }

    @Before
    public void setUp() {
        this.kirja = new Kirja("1", "Kirjailija", "Kirjä", "Julkaisija", "2015");
    }

    @Test
    public void muotoileeKirjanEnsimmaisenRivinOikein() {
        String[] rivit = BibTeXMuotoilija.muotoile(kirja).split("\n");
        assertEquals("@book{1,", rivit[0]);
    }
    
    @Test
    public void viimeisellaRivillaOnAaltoSulku() {
        String[] rivit = BibTeXMuotoilija.muotoile(kirja).split("\n");
        assertEquals("}", rivit[rivit.length - 1]);
    }
    
    @Test
    public void palauttaaOikeanMaaranRiveja() {
        String[] rivit = BibTeXMuotoilija.muotoile(kirja).split("\n");
        assertEquals(6, rivit.length);
    }
    
    @Test
    public void tekijaKenttaMuotoiltuOikein() {
        String[] rivit = BibTeXMuotoilija.muotoile(kirja).split("\n");
        assertEquals("author = {Kirjailija},", rivit[1]);
    }
    
    @Test
    public void eskapoiErikosmerkit() {
        String[] rivit = BibTeXMuotoilija.muotoile(kirja).split("\n");
        assertEquals("title = {Kirj\\\"{a}},", rivit[3]);
    }
    
}
