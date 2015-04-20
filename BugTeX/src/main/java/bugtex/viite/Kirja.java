package bugtex.viite;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Kirjaviite
 */
public class Kirja implements Viite, Serializable {

    private final static String tyyppi = "book";
    
    private final int id;
    private final Map<String, String> kyselyt;
    
    private final static String[] kentat
            = {"tekijä", "nimi", "julkaisija", "vuosi"};

    /**
     * Luo uuden Kirja olion
     * 
     * @param id viitteen tunnus
     * @param tekija kirjan tekijä(t)
     * @param nimi kirjan nimi
     * @param julkaisija kirjan julkaisija
     * @param vuosi kirjan julkaisuvuosi
     */
    public Kirja(int id, String tekija, String nimi, String julkaisija, String vuosi) {
        this.id = id;
        this.kyselyt = new TreeMap<String, String>();
        
        this.kyselyt.put("tekijä", tekija);
        this.kyselyt.put("nimi", nimi);
        this.kyselyt.put("julkaisija", julkaisija);
        this.kyselyt.put("vuosi", vuosi);
    }
    
    /**
     * Luo uuden Kirja olion
     * 
     * @param id viitteen tunnus
     */
    public Kirja(int id, Map<String, String> kyselyt) {
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

    public String getJulkaisija() {
        return kyselyt.get("julkaisija");
    }

    public void setJulkaisija(String julkaisija) {
        kyselyt.put("julkaisija", julkaisija);
    }

    public String getVuosi() {
        return kyselyt.get("vuosi");
    }

    public void setVuosi(String vuosi) {
        kyselyt.put("vuosi", vuosi);
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
        koodit.put("publisher", kyselyt.get("julkaisija"));
        koodit.put("year", kyselyt.get("vuosi"));
        
        return koodit;
    }

}
