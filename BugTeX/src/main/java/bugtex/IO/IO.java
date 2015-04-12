
package bugtex.IO;

public interface IO {

    String lueRivi(String etuTeksti);
    String lueRiviKysymyksella(String etuTeksti, String kysymys);
    
    void tulostaRivi(String teksti);
    
}
