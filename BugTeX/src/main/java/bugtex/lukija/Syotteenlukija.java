package bugtex.lukija;

import java.util.Scanner;

public class Syotteenlukija implements Lukija {

    private final Scanner lukija = new Scanner(System.in);
   
    @Override
    public String lueRivi(String etuTeksti) {
        System.out.print(etuTeksti + " ");
        return lukija.nextLine();
    }
    
    @Override
    public String lueRiviKysymyksella(String etuTeksti, String kysymys) {
        System.out.println(kysymys);
        System.out.print(etuTeksti + " ");
        return lukija.nextLine();
    }

}
