package bugtex.lukija;

import java.util.ArrayList;

public class Valelukija implements Lukija {

    private String rivit[];
    private int i;
    private ArrayList<String> prints;

    public Valelukija(String... syotteet) {
        this.rivit = syotteet;
        prints = new ArrayList<String>();
    }

    public String lueRivi(String etuTeksti) {
        print(etuTeksti);
        if (i < rivit.length) {
            return rivit[i++];
        }
        return "";
    }

    public ArrayList<String> getPrints() {
        return prints;
    }

    public void print(String toPrint) {
        prints.add(toPrint);
    }

    public String lueRiviKysymyksella(String etuTeksti, String kysymys) {
        return lueRivi(etuTeksti);
    }

}
