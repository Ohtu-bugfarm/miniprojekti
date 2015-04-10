package bugtex.idgen;

/**
 * Viitteille ID numeroita generoiva luokka
 */
public class IdGeneraattori implements Generaattori {

    int id;

    public IdGeneraattori() {
        this.id = 1;
    }

    /**
     * 
     * @return uusi id-numero 
     */
    @Override
    public int getId() {
        return id++;
    }
}
