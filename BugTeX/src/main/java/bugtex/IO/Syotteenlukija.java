package bugtex.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Luokka standardisyötteen lukemiseen
 */
public class Syotteenlukija implements IO {

    private final Scanner lukija = new Scanner(System.in);
    private FileWriter kirjoittaja;

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
        File tiedosto = new File(tiedostonNimi);
        try {
            kirjoittaja = new FileWriter(tiedosto);
        } catch (IOException ex) {
            System.out.println("Avattaessa tapahtui virhe: " + ex.getMessage());
        }
    }

    /**
     * Kirjoittaa konstruktorissa määriteltyyn tiedostoon parametrinä annetun
     * Stringin.
     *
     * @param teksti tiedostoon kirjoitettava teksti.
     */
    @Override
    public void kirjoita(String teksti) {
        try {
            kirjoittaja.write(teksti);
        } catch (IOException ex) {
            System.out.println("Tiedostoon kirjoittaessa tapahtui virhe: " + ex.getMessage());
        }
    }

    /**
     * Sulkee kirjoitettavan tiedoston
     *
     */
    @Override
    public void suljeKirjoittaja() {
        try {
            kirjoittaja.close();
        } catch (IOException ex) {
            System.out.println("Tiedoston sulkeminen ei onnistunut: " + ex.getMessage());
        }
    }

    @Override
    public void tulostaRivi(String teksti) {
        System.out.println(teksti);
    }

}
