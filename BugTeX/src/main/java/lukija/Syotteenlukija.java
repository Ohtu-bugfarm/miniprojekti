package lukija;

import java.util.Scanner;

public class Syotteenlukija implements Lukija {

    private Scanner lukija = new Scanner(System.in);

    @Override
    public void tulosta(String teksti) {
        System.out.println(teksti);
    }

    @Override
    public String lueRivi(String syote) {
        System.out.print(syote + " ");
        return lukija.nextLine();
    }

}
