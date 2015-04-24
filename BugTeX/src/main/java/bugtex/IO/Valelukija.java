package bugtex.IO;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Testaamista helpottava luokka, joka lukee parametreina annettuja syötteitä.
 */
public class Valelukija implements IO {

    private final List<String> tulostukset;
    private final String[] rivit;
    private int i;

    /**
     * Alustaa valelukijan.
     *
     * @param syotteet lista syötteistä, jotka valelukija myöhemmin lukee
     */
    public Valelukija(String... syotteet) {
        this.tulostukset = new ArrayList<String>();
        this.rivit = syotteet;
        i = 0;
    }

    @Override
    public String lueRivi(String etuTeksti) {
        if (i < rivit.length) {
            return rivit[i++];
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public String lueRiviKysymyksella(String etuTeksti, String kysymys) {
        this.tulostukset.add(kysymys);
        return lueRivi(etuTeksti);
    }

    @Override
    public void tulostaRivi(String teksti) {
        this.tulostukset.add(teksti);
    }

    public List<String> getTulostukset() {
        return this.tulostukset;
    }

    @Override
    public int lueNumeroKysymyksella(String etuTeksti, String kysymys) {
        return Integer.parseInt(lueRivi(etuTeksti));
    }

}
