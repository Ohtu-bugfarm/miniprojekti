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

public class TiedostoonKirjoittajaTest {

    private TiedostoonKirjoittaja kirjoittaja;
    private Scanner tiedostolukija;
    private final String tiedostoNimi = "test.bib";

    @Before
    public void setUp() throws IOException {
        kirjoittaja = new TiedostoonKirjoittaja(tiedostoNimi);
        try {
            tiedostolukija = new Scanner(new File(tiedostoNimi));
        } catch (FileNotFoundException e) {

        }
    }

    @Test
    public void kirjoitaTiedostoon() {
        kirjoittaja.kirjoita("moro test");
        kirjoittaja.suljeKirjoittaja();
        String testi = "moro test";
        assertEquals(testi, tiedostolukija.nextLine());
    }

    @After
    public void setDown() {
        tiedostolukija.close();
        Path polku = Paths.get(tiedostoNimi);
        try {
            Files.deleteIfExists(polku);
        } catch (IOException ex) {

        }
    }
    
}
