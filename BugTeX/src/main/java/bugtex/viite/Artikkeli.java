package bugtex.viite;

import java.util.Map;
import java.util.TreeMap;

/**
 * Artikkeliviite
 */
public class Artikkeli implements Viite {

    private final static String tyyppi = "article";
    
    private final int id;
    private final Map<String, String> kyselyt;
    
    private final static String[] kentat
            = {"tekijä", "nimi", "lehti", "vuosi", "nide"};

    /**
     * Luo uuden Artikkeli olion
     * 
     * @param id viitteen tunnus
     * @param tekija artikkelin tekijä(t)
     * @param nimi artikkelin nimi
     * @param lehti lehti, jossa artikkeli julkaistu
     * @param vuosi artikkelin julkaisuvuosi
     * @param nide artikkelin nide
     */
    public Artikkeli(int id, String tekija, String nimi, String lehti, String vuosi, String nide) {
        this.id = id;
        this.kyselyt = new TreeMap<String, String>();
        
        this.kyselyt.put("tekijä", tekija);
        this.kyselyt.put("nimi", nimi);
        this.kyselyt.put("lehti", lehti);
        this.kyselyt.put("vuosi", vuosi);
        this.kyselyt.put("nide", nide);
    }
    
    /**
     * Luo uuden Artikkeli olion
     * 
     * @param id viitteen tunnus
     */
    public Artikkeli(int id, Map<String, String> kyselyt) {
        this.id = id;
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
    public int getID() {
        return this.id;
    }

    public String getTekija() {
        return kyselyt.get("tekijä");
    }

    public void setTekija(String tekija) {
        kyselyt.put("tekijä", tekija);
    }

    public String getNimi() {
        return kyselyt.get("nimi");
    }

    public void setNimi(String nimi) {
        kyselyt.put("nimi", nimi);
    }

    public String getLehti() {
        return kyselyt.get("lehti");
    }

    public void setLehti(String julkaisija) {
        kyselyt.put("lehti", julkaisija);
    }

    public String getVuosi() {
        return kyselyt.get("vuosi");
    }

    public void setVuosi(String vuosi) {
        kyselyt.put("vuosi", vuosi);
    }
    
    public String getNide() {
        return kyselyt.get("nide");
    }
    
    public void setNide(String nide) {
        kyselyt.put("nide", nide);
    }
    
    @Override
    public String toString() {
        String s = "tunnus: " + this.id + "\n";
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
