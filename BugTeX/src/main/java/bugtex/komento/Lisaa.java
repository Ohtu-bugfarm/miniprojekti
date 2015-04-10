package bugtex.komento;

import bugtex.idgen.Generaattori;
import bugtex.idgen.IdGeneraattori;
import bugtex.lukija.Syotteenlukija;
import bugtex.tietokanta.MuistiTietokanta;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Kirja;
import bugtex.viite.Viite;

public class Lisaa implements Komento {

    private final Syotteenlukija lukija;
    private final Generaattori idgen;
    private final TietokantaRajapinta db;
    private Viite viite;

    public Lisaa(Syotteenlukija lukija) {
        this.lukija = lukija;
        this.idgen = new IdGeneraattori();
        this.db = new MuistiTietokanta();
    }

    @Override
    public void suorita() {
        int id = idgen.getId();
        String tekija = lukija.lueRiviKysymyksella(">", "tekijä?");
        String nimi = lukija.lueRiviKysymyksella(">", "nimi?");
        String julkaisija = lukija.lueRiviKysymyksella(">", "julkaisija?");
        String vuosi = lukija.lueRiviKysymyksella(">", "vuosi?");

        viite = new Kirja(id, tekija, nimi, julkaisija, vuosi);
        if (db.lisaa(viite)) {
            System.out.println("Kirjan lisäys onnistui");
        } else {
            System.out.println("Lisäys ei onnistunut");
        }
    }

}
