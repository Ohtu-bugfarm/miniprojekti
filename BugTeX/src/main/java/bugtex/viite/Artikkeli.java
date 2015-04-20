package bugtex.viite;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Artikkeliviite
 */
public class Artikkeli implements Viite, Serializable {

    private final static String tyyppi = "article";
    
    private final Map<String, String> kyselyt;
    
    private final static String[] kentat
            = {"tunnus", "tekijä", "nimi", "lehti", "vuosi", "nide"};

    /**
     * Luo uuden Artikkeli olion
     * 
     * @param tunnus viitteen tunnus
     * @param tekija artikkelin tekijä(t)
     * @param nimi artikkelin nimi
     * @param lehti lehti, jossa artikkeli julkaistu
     * @param vuosi artikkelin julkaisuvuosi
     * @param nide artikkelin nide
     */
    public Artikkeli(String tunnus, String tekija, String nimi, String lehti, String vuosi, String nide) {
        this.kyselyt = new TreeMap<String, String>();
        
        this.kyselyt.put("tunnus", tunnus);
        this.kyselyt.put("tekijä", tekija);
        this.kyselyt.put("nimi", nimi);
        this.kyselyt.put("lehti", lehti);
        this.kyselyt.put("vuosi", vuosi);
        this.kyselyt.put("nide", nide);
    }
    
    /**
     * Luo uuden Artikkeli olion
     * 
     */
    public Artikkeli(Map<String, String> kyselyt) {
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

    public String getLehti() {
        return kyselyt.get("lehti");
    }

    public String getVuosi() {
        return kyselyt.get("vuosi");
    }
    
    public String getNide() {
        return kyselyt.get("nide");
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
        koodit.put("journal", kyselyt.get("lehti"));
        koodit.put("year", kyselyt.get("vuosi"));
        koodit.put("volume", kyselyt.get("nide"));
        
        return koodit;
    }

}
