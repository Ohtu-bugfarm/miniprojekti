package bugtex.komento;

import bugtex.idgen.Generaattori;
import bugtex.idgen.IdGeneraattori;
import bugtex.lukija.Lukija;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Kirja;
import bugtex.viite.Viite;

public class Lisaa implements Komento {

    private final Lukija lukija;
    private final Generaattori idgen;
    private final TietokantaRajapinta db;
    private Viite viite;

    public Lisaa(Lukija lukija, TietokantaRajapinta db) {
        this.lukija = lukija;
        this.db = db;
        this.idgen = new IdGeneraattori();
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
