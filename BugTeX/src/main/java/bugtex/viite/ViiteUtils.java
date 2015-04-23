package bugtex.viite;

/**
 * Apumetodeja viiteolioille
 */
public class ViiteUtils {
    
    /**
     * Palauttaa ensimmäisen sanan merkkijonossa pienin kirjaimin
     * 
     * @param mjono merkkijono, josta ensimmäinen sana otetaan
     * @param jakaja sanojen erittelyyn käytettävä merkkijono
     * @return ensimmäinen sana merkkijonossa
     */
    public static String ensimmainenSana(String mjono, String jakaja) {
        String[] jako = mjono.split(jakaja);
        
        if (jako.length == 0) {
            return mjono;
        }
        
        return jako[0].toLowerCase();
    }
    
}
