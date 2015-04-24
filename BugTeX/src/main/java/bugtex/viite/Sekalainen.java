package bugtex.viite;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Sekalainen viite.
 */
public class Sekalainen implements Viite, Serializable {

    private final static String TYYPPI = "misc";

    private final Map<String, String> kyselyt;

    private final static String[] KENTAT
            = {"tekijä", "nimi", "julkaisutyyppi", "kuukausi", "vuosi", "huomautus"};

    /**
     * Luo uuden Sekalainen-olion
     *
     * @param tekija tekijä(t)
     * @param nimi lähteen nimi
     * @param julkaisutyyppi miten lähde julkaistu
     * @param kuukausi lähteen julkaisukuukausi
     * @param vuosi lähteen julkaisuvuosi
     * @param huomautus muuta infoa
     */
    
    public Sekalainen(String tekija, String nimi, String julkaisutyyppi, String kuukausi, String vuosi, String huomautus) {
        this.kyselyt = new TreeMap<String, String>();
        
        this.kyselyt.put("tekijä", tekija);
        this.kyselyt.put("nimi", nimi);
        this.kyselyt.put("julkaisutyyppi", julkaisutyyppi);
        this.kyselyt.put("kuukausi", kuukausi);
        this.kyselyt.put("vuosi", vuosi);
        this.kyselyt.put("huomautus", huomautus);
    }
    
    /**
     * Luo uuden Sekalainen olion
     * 
     */
    public Sekalainen(Map<String, String> kyselyt) {
        this.kyselyt = kyselyt;
    }
    
    public static String[] getKentat() {
        return KENTAT;
    }
    
    @Override
    public Map<String, String> getKyselyt() {
        return this.kyselyt;
    }

    @Override
    public String getTyyppi() {
        return TYYPPI;
    }
    
    @Override
    public String getTunnus() {
        if (kyselyt.get("tunnus") != null) {
            return kyselyt.get("tunnus");
        }

        return ViiteUtils.ensimmainenSana(getTekija(), ",") + getVuosi() +
               ViiteUtils.ensimmainenSana(getNimi(), " ");
    }
    
    public String getTekija() {
        return kyselyt.get("tekijä");
    }
    
    public String getNimi() {
        return kyselyt.get("nimi");
    }

    public String getJulkaisutyyppi() {
        return kyselyt.get("julkaisutyyppi");
    }

    public String getKuukausi() {
        return kyselyt.get("kuukausi");
    }
    
    public String getVuosi() {
        return kyselyt.get("vuosi");
    }
    
    public String getHuomautus() {
        return kyselyt.get("huomautus");
    }
    
    @Override
    public String toString() {
        String s = "tunnus: " + getTunnus() + "\n";
        for (String kentta : KENTAT) {
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
        koodit.put("howpublished", kyselyt.get("julkaisutyyppi"));
        koodit.put("month", kyselyt.get("kuukausi"));
        koodit.put("year", kyselyt.get("vuosi"));
        koodit.put("note", kyselyt.get("huomautus"));
        
        return koodit;
    }

}
