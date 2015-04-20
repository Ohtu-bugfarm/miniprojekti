package bugtex.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class SyoteenLukuTest {

    private Syotteenlukija lukija;
    private Scanner tiedostolukija;

    @Before
    public void setUp() {
        lukija = new Syotteenlukija();
        lukija.asetaTiedosto("test.bib");
        try {
            tiedostolukija = new Scanner(new File("test.bib"));
        } catch (FileNotFoundException e) {

        }
    }

    @Test
    public void kirjoitaTiedostoon() {
        lukija.kirjoita("moro test");
        lukija.suljeKirjoittaja();
        String testi = "moro test";
        assert (testi.equals(tiedostolukija.nextLine()));
    }

    @After
    public void setDown() {
        tiedostolukija.close();
    }

}
