package bugtex.komento;

import bugtex.IO.IO;
import bugtex.bibtex.BibTeXMuotoilija;
import bugtex.tietokanta.TietokantaRajapinta;
import bugtex.viite.Viite;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneroiBibtexTiedosto implements Komento {

    public final static String KOMENTO = "gen";
    private final TietokantaRajapinta db;
    BibTeXMuotoilija muoto = new BibTeXMuotoilija();
    private File file;
    private IO io;

    private FileWriter writer;

    public GeneroiBibtexTiedosto(IO io, TietokantaRajapinta db) {
        this.io = io;
        this.db = db;
        this.file = new File("Bibtex.bib");
    }

    @Override
    public void suorita() {
        generoiTiedosto();

    }

    @Override
    public String toString() {
        return KOMENTO;
    }

    private void generoiTiedosto() {
        List<Viite> kirjoitettavat = db.annaViitteet();

        if (kirjoitettavat.isEmpty()) {
            io.tulostaRivi("Sinulla ei ole yhtään viitettä talletettuna");
            return;
        }
        try {
            writer = new FileWriter(this.file);

            for (Viite viite : kirjoitettavat) {
                writer.write(BibTeXMuotoilija.muotoile(viite) + "\n" + "\n");
            }
            io.tulostaRivi("Gen onnistui");
            writer.close();
        } catch (IOException ex) {
            io.tulostaRivi("Tiedostoon kirjoittaessa tapahtui virhe: " + ex.getMessage());
        }
    }

}
