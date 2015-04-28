package bugtex.IO;

/**
 * Rajapinta syötteen lukemisesta ja tulostamisesta vastaaville luokille.
 */
public interface IO {

    /**
     * Lue rivi syötteestä.
     *
     * @param etuTeksti lukemista ennen tulostettava teksti
     * @return luettu rivi
     */
    String lueRivi(String etuTeksti);

    /**
     * Esitä annettu kysymys ja lue rivi syötteestä.
     *
     * @param etuTeksti lukemista ennen tulostettava teksti
     * @param kysymys esitettävä kysymys
     * @return luettu rivi
     */
    String lueRiviKysymyksella(String etuTeksti, String kysymys);

    /**
     * Esitä annettu kysymys ja lue numero syötteestä.
     *
     * @param etuTeksti lukemista ennen tulostettava teksti
     * @param kysymys esitettävä kysymys
     * @return luettu numero
     */
    int lueNumeroKysymyksella(String etuTeksti, String kysymys);

    /**
     * Tulosta rivi rivivaihdolla.
     *
     * @param teksti tulostettava teksti
     */
    void tulostaRivi(String teksti);

}
