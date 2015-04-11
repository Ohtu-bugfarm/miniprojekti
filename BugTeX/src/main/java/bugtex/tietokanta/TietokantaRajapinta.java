package bugtex.tietokanta;

import bugtex.viite.Viite;
import java.util.List;

/**
 * Rajapinta viiteolioita säilövälle tietokannalle
 */
public interface TietokantaRajapinta {
    
    /**
     * Lisää viitteen tietokantaan
     * 
     * @param viite Lisättävä viite
     * @return true jos lisäys onnistuu, false muuten
     */
    boolean lisaa(Viite viite);
    
    /**
     * Hae numerotunnusta vastaava viiteolio tietokannasta
     * 
     * @param id Haettavan viitteen numerotunnus
     * @return Tunnusta vastaava viiteolio, null jos tunnusta vastaavaa
     *         viitettä ei ole olemassa
     */
    Viite haeTunnuksella(int id);
    
    /**
     * Poista numerotunnusta vastaava viiteolio tietokannasta
     * 
     * @param id Haettavan viitteen numerotunnus
     * @return true jos poisto onnistuu, false muuten
     */
    boolean poistaTunnuksella(int id);
    
    /**
     * Antaa listan viitteistä
     * 
     * @return lista viitteistä
     */
    List<Viite> annaViitteet();
}
