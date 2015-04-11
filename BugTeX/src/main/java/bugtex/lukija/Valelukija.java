
package bugtex.lukija;

public class Valelukija implements Lukija {

    String rivit[];
    int i;
    
    public Valelukija(String... syotteet){
        this.rivit = syotteet;
        i = 0;
    }
    
    @Override
    public String lueRivi(String etuTeksti) {
       if (i < rivit.length){
           return rivit[i++];
       }else{        
        return "";
       }
    }

    @Override
    public String lueRiviKysymyksella(String etuTeksti, String kysymys) {
    return lueRivi(etuTeksti);
    }
    
}
