package bugtex.tietokanta;

import bugtex.viite.Viite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Tallettaa viitteet tiedostoon.
 */
public class TiedostoTietokanta implements TietokantaRajapinta {

    private List<Viite> viitteet;
    private FileOutputStream fout;
    private FileInputStream fin;
    private ObjectOutputStream objWriter;
    private ObjectInputStream objReader;
    private final File myRefs;

    /**
     * Luo uuden tiedoston jos ei sitä ole, muuten avaa olemassaolevan.
     *
     * @param tiedosto
     * @throws ClassNotFoundException
     */
    public TiedostoTietokanta(String tiedosto) throws ClassNotFoundException {
        viitteet = new ArrayList<>();
        myRefs = new File(tiedosto);

        try {
            myRefs.getParentFile().mkdirs();
            if (!myRefs.createNewFile()) {
                viitteet = lueViitteet();
            }
        } catch (IOException ex) {
            Logger.getLogger(TiedostoTietokanta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private List<Viite> lueViitteet() throws IOException, ClassNotFoundException {
        List<Viite> luetut = null;

        fin = new FileInputStream(myRefs);
        if (fin.available() > 0) {
            objReader = new ObjectInputStream(fin);
            luetut = (ArrayList<Viite>) objReader.readObject();
            objReader.close();
        }

        fin.close();
        return luetut;
    }

    @Override
    public boolean lisaa(Viite viite) {
        viitteet.add(viite);
        return paivita();
    }

    @Override
    public Viite haeTunnuksella(String tunnus) {
        for (Viite viite : viitteet) {
            if (viite.getTunnus() != null && viite.getTunnus().equals(tunnus)) {
                return viite;
            }
        }

        return null;
    }

    @Override
    public boolean poistaTunnuksella(String tunnus) {
        Viite viite = haeTunnuksella(tunnus);

        if (!viitteet.remove(viite)) {
            return false;
        }

        return paivita();
    }

    @Override
    public List<Viite> annaViitteet() {
        return viitteet;
    }

    /**
     * Hae tietokannan tallennustiedosto.
     *
     * @return tallennukseen käytettävää tiedostoa vastaava File-olio
     */
    public File tiedosto() {
        return myRefs;
    }

    @Override
    public boolean paivita() {
        try {
            kirjoitaViitteetTiedostoon();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TiedostoTietokanta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TiedostoTietokanta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    private void kirjoitaViitteetTiedostoon() throws FileNotFoundException, IOException {
        fout = new FileOutputStream(myRefs);
        objWriter = new ObjectOutputStream(fout);
        objWriter.writeObject(viitteet);
        objWriter.close();
        fout.close();
    }

}
