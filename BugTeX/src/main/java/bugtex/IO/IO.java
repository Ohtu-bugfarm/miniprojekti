package bugtex.IO;

/**
 * Rajapinta syötteen lukemisesta ja tulostamisesta vastaaville luokille
 */
public interface IO {

    /**
     * Lue rivi syötteestä
     * 
     * @param etuTeksti
     * @return luettu rivi
     */
    String lueRivi(String etuTeksti);
    
    /**
     * Esitä annettu kysymys ja lue rivi syötteestä
     * 
     * @param etuTeksti
     * @param kysymys esitettävä kysymys
     * @return luettu rivi
     */
    String lueRiviKysymyksella(String etuTeksti, String kysymys);
    
    int lueNumeroKysymyksella(String etuTeksti, String kysymys);
    
    /**
     * Tulosta rivi rivivaihdolla
     * 
     * @param teksti tulostettava teksti
     */
    void tulostaRivi(String teksti);
    
}
