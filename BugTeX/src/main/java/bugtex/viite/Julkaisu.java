package bugtex.viite;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Viitetyyppi konferenssijulkaisulle
 */
public class Julkaisu implements Viite, Serializable {

    private final static String tyyppi = "inproceedings";
    
    private final Map<String, String> kyselyt;
    
    private final static String[] kentat
            = {"tunnus", "tekijä", "nimi", "kirjan nimi", "vuosi"};

    /**
     * Luo uuden Julkaisu olion
     * 
     * @param tunnus viitteen tunnus
     * @param tekija julkaisun tekijä(t)
     * @param nimi julkaisun nimi
     * @param kirjanNimi kirjan nimi
     * @param vuosi julkaisun julkaisuvuosi
     */
    public Julkaisu(String tunnus, String tekija, String nimi, String kirjanNimi, String vuosi) {
        this.kyselyt = new TreeMap<String, String>();
        
        this.kyselyt.put("tekija", tekija);
        this.kyselyt.put("nimi", nimi);
        this.kyselyt.put("kirjan nimi", kirjanNimi);
        this.kyselyt.put("vuosi", vuosi);
    }
    
    /**
     * Luo uuden Julkaisu olion
     * 
     * @param kyselyt
     */
    public Julkaisu(Map<String, String> kyselyt) {
        this.kyselyt = kyselyt;
    }
    
    public static String[] getKentat() {
        return kentat;
    }
    
    @Override
    public String getTyyppi() {
        return tyyppi;
    }
    
    @Override
    public Map<String, String> getKyselyt() {
        return this.kyselyt;
    }

    @Override
    public String getTunnus() {
        return kyselyt.get("tunnus");
    }

    public String getTekija() {
        return kyselyt.get("tekijä");
    }
    
    public String getNimi() {
        return kyselyt.get("nimi");
    }

    public String getKirjanNimi() {
        return kyselyt.get("kirjan nimi");
    }

    public String getVuosi() {
        return kyselyt.get("vuosi");
    }
    
    @Override
    public String toString() {
        String s = "";
        for (String kentta : kentat) {
            if (kyselyt.get(kentta) != null) {
                s += kentta + ": " + kyselyt.get(kentta) + "\n";
            }
        }
        
        return s;
    }

    @Override
    public Map<String, String> koodaus() {
        Map<String, String> koodit = new TreeMap<String, String>();
        
        koodit.put("author", kyselyt.get("tekijä"));
        koodit.put("title", kyselyt.get("nimi"));
        koodit.put("booktitle", kyselyt.get("kirjan nimi"));
        koodit.put("year", kyselyt.get("vuosi"));
        
        return koodit;
    }

}
