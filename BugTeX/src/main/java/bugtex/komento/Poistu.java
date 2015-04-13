package bugtex.komento;

public class Poistu implements Komento {
    
    public final static String KOMENTO = "Poistu";
    
    @Override
    public void suorita() {
        System.exit(0);
    }
    
}
