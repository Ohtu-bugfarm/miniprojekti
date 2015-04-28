package bugtex.viite;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Artikkeliviite.
 */
public class Artikkeli implements Viite, Serializable {

    private final static String TYYPPI = "article";

    private final Map<String, String> kyselyt;

    public final static String[] KENTAT
            = {"tekijä", "nimi", "lehti", "vuosi", "nide"};

    /**
     * Luo uuden Artikkeli olion.
     *
     * @param tekija artikkelin tekijä(t)
     * @param nimi artikkelin nimi
     * @param lehti lehti, jossa artikkeli julkaistu
     * @param vuosi artikkelin julkaisuvuosi
     * @param nide artikkelin nide
     */
    public Artikkeli(String tekija, String nimi, String lehti, String vuosi, String nide) {
        this.kyselyt = new TreeMap<String, String>();

        this.kyselyt.put("tekijä", tekija);
        this.kyselyt.put("nimi", nimi);
        this.kyselyt.put("lehti", lehti);
        this.kyselyt.put("vuosi", vuosi);
        this.kyselyt.put("nide", nide);
    }

    /**
     * Luo uuden Artikkeli olion.
     */
    public Artikkeli(Map<String, String> kyselyt) {
        this.kyselyt = kyselyt;
    }

    @Override
    public String getTyyppi() {
        return TYYPPI;
    }

    @Override
    public Map<String, String> getKyselyt() {
        return this.kyselyt;
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
        String muotoiltu = "tunnus: " + getTunnus() + "\n";
        for (String kentta : KENTAT) {
            if (kyselyt.get(kentta) != null) {
                muotoiltu += kentta + ": " + kyselyt.get(kentta) + "\n";
            }
        }

        return muotoiltu;
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
