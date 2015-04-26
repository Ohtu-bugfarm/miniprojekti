package bugtex.IO;

import java.util.Scanner;

/**
 * Luokka standardisyötteen lukemiseen.
 */
public class Syotteenlukija implements IO {

    private final Scanner lukija = new Scanner(System.in);

    @Override
    public String lueRivi(String etuTeksti) {
        System.out.print(etuTeksti + " ");
        if (lukija.hasNextInt()) {
            return String.valueOf(lukija.nextLine());
        } else {
            return lukija.nextLine();
        }
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

    @Override
    public void tulostaRivi(String teksti) {
        System.out.println(teksti);
    }

}
