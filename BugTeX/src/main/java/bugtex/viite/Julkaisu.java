package bugtex.viite;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Viitetyyppi konferenssijulkaisulle.
 */
public class Julkaisu implements Viite, Serializable {

    private final static String TYYPPI = "inproceedings";

    private final Map<String, String> kyselyt;

    private final static String[] KENTAT
            = {"tekijä", "nimi", "kirjan nimi", "vuosi"};

    /**
     * Luo uuden Julkaisu olion.
     *
     * @param tekija julkaisun tekijä(t)
     * @param nimi julkaisun nimi
     * @param kirjanNimi kirjan nimi
     * @param vuosi julkaisun julkaisuvuosi
     */
    public Julkaisu(String tekija, String nimi, String kirjanNimi, String vuosi) {
        this.kyselyt = new TreeMap<String, String>();

        this.kyselyt.put("tekijä", tekija);
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
        return KENTAT;
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

    public String getKirjanNimi() {
        return kyselyt.get("kirjan nimi");
    }

    public String getVuosi() {
        return kyselyt.get("vuosi");
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
        koodit.put("booktitle", kyselyt.get("kirjan nimi"));
        koodit.put("year", kyselyt.get("vuosi"));

        return koodit;
    }

}
