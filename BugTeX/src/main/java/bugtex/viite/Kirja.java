package bugtex.viite;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Kirjaviite
 */
public class Kirja implements Viite, Serializable {

    private final static String tyyppi = "book";
    
    private final Map<String, String> kyselyt;
    
    private final static String[] kentat
            = {"tunnus", "tekijä", "nimi", "julkaisija", "vuosi"};

    /**
     * Luo uuden Kirja olion
     * 
     * @param tunnus viitteen tunnus
     * @param tekija kirjan tekijä(t)
     * @param nimi kirjan nimi
     * @param julkaisija kirjan julkaisija
     * @param vuosi kirjan julkaisuvuosi
     */
    public Kirja(String tunnus, String tekija, String nimi, String julkaisija, String vuosi) {
        this.kyselyt = new TreeMap<String, String>();
        
        this.kyselyt.put("tunnus", tunnus);
        this.kyselyt.put("tekijä", tekija);
        this.kyselyt.put("nimi", nimi);
        this.kyselyt.put("julkaisija", julkaisija);
        this.kyselyt.put("vuosi", vuosi);
    }
    
    /**
     * Luo uuden Kirja olion
     * 
     */
    public Kirja(Map<String, String> kyselyt) {
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

    public String getJulkaisija() {
        return kyselyt.get("julkaisija");
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
        koodit.put("publisher", kyselyt.get("julkaisija"));
        koodit.put("year", kyselyt.get("vuosi"));
        
        return koodit;
    }

}
