package bugtex.idgen;

/**
 * Viitteille ID numeroita generoiva luokka
 */
public class IdGeneraattori implements Generaattori {

    int id;

    /**
     * Alustaa ID-generaattorin
     */
    public IdGeneraattori() {
        this.id = 1;
    }

    /**
     * Hae uusi ID-numero
     * 
     * @return uusi id-numero
     */
    @Override
    public int getId() {
        return id++;
    }
    
}
