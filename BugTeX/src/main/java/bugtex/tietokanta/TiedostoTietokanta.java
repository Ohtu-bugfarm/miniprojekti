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
 * talleta viitteet tiedostoon
 */
public class TiedostoTietokanta implements TietokantaRajapinta {

    private List<Viite> viitteet;
    private FileOutputStream fout;
    private FileInputStream fin;
    private ObjectOutputStream objWriter;
    private ObjectInputStream objReader;

    private File myRefs;

    /**
     *Luo uuden tiedoston jos ei sitä ole, muuten avaa olemassaolevan
     * @param tiedosto
     * @throws ClassNotFoundException
     */
    public TiedostoTietokanta(String tiedosto) throws ClassNotFoundException {
        myRefs = new File(tiedosto);
        try {
            if (myRefs.createNewFile()) {
                viitteet = new ArrayList<>();
            } else {
                fin = new FileInputStream(myRefs);
                objReader = new ObjectInputStream(fin);
                viitteet = (ArrayList<Viite>) objReader.readObject();
                objReader.close();
                fin.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(TiedostoTietokanta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * lisää uuden viitteen tiedostoon
     * @param viite
     * @return true jos lisäys onnistui, muuten false
     */
    @Override
    public boolean lisaa(Viite viite) {
        viitteet.add(viite);
        try {
            fout = new FileOutputStream(myRefs);
            objWriter = new ObjectOutputStream(fout);
            objWriter.writeObject(viitteet);
            objWriter.close();
            fout.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TiedostoTietokanta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TiedostoTietokanta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * hakee viitteen id-numeron perusteella
     * @param id
     * @return viite jos löytyy, muuten null
     */
    @Override
    public Viite haeTunnuksella(int id) {
        for (Viite viite : viitteet) {
            if (viite.getID() == id) {
                return viite;
            }
        }
        return null;
    }

    /**
     * poistaa viitteen id-numeron perusteella
     * @param id
     * @return true jos poisto onnistui, muuten false
     */
    @Override
    public boolean poistaTunnuksella(int id) {
        Viite viite = haeTunnuksella(id);
        return viitteet.remove(viite);
    }

    /**
     * listaa laikki viitteet
     * @return lista kaikista viitteistä
     */
    @Override
    public List<Viite> annaViitteet() {
        return viitteet;
    }

}
