package bugtex.IO;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Valelukija implements IO {

    List<String> tulostukset;
    String rivit[];
    int i;
    
    public Valelukija(String... syotteet){
        this.tulostukset = new ArrayList<String>();
        this.rivit = syotteet;
        i = 0;
    }
    
    @Override
    public String lueRivi(String etuTeksti) {
       if (i < rivit.length){
           return rivit[i++];
       } else{        
           throw new NoSuchElementException();
       }
    }

    @Override
    public String lueRiviKysymyksella(String etuTeksti, String kysymys) {
        return lueRivi(etuTeksti);
    }

    @Override
    public void tulostaRivi(String teksti) {
        this.tulostukset.add(teksti);
    }
    
    public List<String> getTulostukset() {
        return this.tulostukset;
    }
    
}
