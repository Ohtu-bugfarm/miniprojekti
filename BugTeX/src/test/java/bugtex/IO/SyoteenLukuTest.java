package bugtex.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class SyoteenLukuTest {

    private Syotteenlukija lukija;
    private Scanner tiedostolukija;
    private final String tiedostonnimi = "test.bib";

    @Before
    public void setUp() {
        lukija = new Syotteenlukija();
        lukija.asetaTiedosto(tiedostonnimi);
        try {
            tiedostolukija = new Scanner(new File(tiedostonnimi));
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
        Path polku = Paths.get(tiedostonnimi);
        try {
            Files.deleteIfExists(polku);
        } catch (IOException ex) {

        }
    }
}
