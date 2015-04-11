package bugtex.komento;

import bugtex.idgen.Generaattori;
import bugtex.idgen.IdGeneraattori;
import bugtex.IO.IO;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Kirja;
import bugtex.viite.Viite;

public class Lisaa implements Komento {

    private final IO io;
    private final Generaattori idgen;
    private final TietokantaRajapinta db;
    private Viite viite;

    public Lisaa(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
        this.idgen = new IdGeneraattori();
    }

    @Override
    public void suorita() {
        int id = idgen.getId();
        String tekija = io.lueRiviKysymyksella(">", "tekijä?");
        String nimi = io.lueRiviKysymyksella(">", "nimi?");
        String julkaisija = io.lueRiviKysymyksella(">", "julkaisija?");
        String vuosi = io.lueRiviKysymyksella(">", "vuosi?");

        viite = new Kirja(id, tekija, nimi, julkaisija, vuosi);
        if (db.lisaa(viite)) {
            io.tulostaRivi("Kirjan lisäys onnistui");
        } else {
            io.tulostaRivi("Lisäys ei onnistunut");
        }
    }

}
