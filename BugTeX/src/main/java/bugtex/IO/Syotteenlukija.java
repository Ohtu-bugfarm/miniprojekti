package bugtex.IO;

import java.util.Scanner;

import bugtex.viite.Viite;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Luokka standardisyötteen lukemiseen
 */
public class Syotteenlukija implements IO {

    private final Scanner lukija = new Scanner(System.in);
    private FileWriter writer;
    private IO io;
    private File file;
    Viite viite;

    @Override
    public String lueRivi(String etuTeksti) {
        System.out.print(etuTeksti + " ");
        return lukija.nextLine();
    }

    @Override
    public String lueRiviKysymyksella(String etuTeksti, String kysymys) {
        System.out.println(kysymys);
        return lueRivi(etuTeksti);
    }

    @Override
    public int lueNumeroKysymyksella(String etuTeksti, String kysymys) {
        int numero = 0;
        while (true) {
            String id = lueRiviKysymyksella(etuTeksti, kysymys);
            try {
                numero = Integer.parseInt(id);
                break;
            } catch (NumberFormatException e) {
                tulostaRivi("et antanut numeroa");
            }
        }

        return numero;
    }

    /**
     * asettaa tiedoston johon kirjoitetaan parametrin osoittamaan tiedotoon
     *
     * @param tiedostonNimi
     */
    @Override
    public void asetaTiedosto(String tiedostonNimi) {
        this.file = new File(tiedostonNimi);
        try {
            writer = new FileWriter(this.file);
        } catch (IOException ex) {
            io.tulostaRivi("Avattaessa tapahtui virhe: " + ex.getMessage());
        }
    }

    /**
     * Kirjoittaa konstruktorissa määriteltyyn tiedostoon parametrinä annetun
     * Stringin.
     *
     * @param teksti tiedostoon kirjoitettava teksti.
     * @throws java.io.IOException
     */
    @Override
    public void kirjoita(String teksti) {
        try {
            writer.write(teksti);
        } catch (IOException ex) {
            io.tulostaRivi("Tiedostoon kirjoittaessa tapahtui virhe: " + ex.getMessage());
        }
    }

    /**
     * Sulkee kirjoitettavan tiedoston
     *
     * @throws java.io.Exception
     */
    @Override
    public void suljeKirjoittaja() {
        try {
            writer.close();
        } catch (IOException ex) {
            io.tulostaRivi("Tiedoston sulkeminen ei onnistunut: " + ex.getMessage());
        }
    }

    @Override
    public void tulostaRivi(String teksti) {
        System.out.println(teksti);
    }

}
