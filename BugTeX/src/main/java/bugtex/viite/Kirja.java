package bugtex.viite;

/**
 * Kirjaviite
 */
public class Kirja implements Viite {

    private final int id;

    private String tekija, nimi, julkaisija;
    private int vuosi;

    /**
     * Luo uuden Kirja olion
     * 
     * @param id viitteen tunnus
     * @param tekija kirjan tekijä(t)
     * @param nimi kirjan nimi
     * @param julkaisija kirjan julkaisija
     * @param vuosi kirjan julkaisuvuosi
     */
    public Kirja(int id, String tekija, String nimi, String julkaisija, int vuosi) {
        this.id = id;
        this.tekija = tekija;
        this.nimi = nimi;
        this.julkaisija = julkaisija;
        this.vuosi = vuosi;
    }

    @Override
    public int getID() {
        return this.id;
    }

    public String getTekija() {
        return tekija;
    }

    public void setTekija(String tekija) {
        this.tekija = tekija;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getJulkaisija() {
        return julkaisija;
    }

    public void setJulkaisija(String julkaisija) {
        this.julkaisija = julkaisija;
    }

    public int getVuosi() {
        return vuosi;
    }

    public void setVuosi(int vuosi) {
        this.vuosi = vuosi;
    }
    
    @Override
    public String toString() {
        return "Tunnus: "        + this.id         + "\n"
                + "Tekijä: "     + this.tekija     + "\n"
                + "Nimi: "       + this.nimi       + "\n"
                + "Julkaisija: " + this.julkaisija + "\n"
                + "Vuosi: "      + this.vuosi      + "\n";
    }

}
