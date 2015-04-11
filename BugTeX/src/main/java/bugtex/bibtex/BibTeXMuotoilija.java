package bugtex.bibtex;

import java.util.Map;

import bugtex.viite.Viite;

/**
 * Toiminnallisuus BiBTeX-muotoilulle
 */
public class BibTeXMuotoilija {
    
    /**
     * Muotoilee Viite-olion BibTeX-muotoiseksi merkkijonoksi
     * 
     * @param viite
     * @return viite BiBTeX-muotoisena merkkijonona
     */
    public static String muotoile(Viite viite) {
        Map<String, String> koodaus = viite.koodaus();
        
        StringBuilder sb = new StringBuilder();
        muotoileOtsake(sb, viite.getTyyppi());
        muotoileKentat(sb, koodaus);

        sb.append("}");
        return sb.toString();
    }
    
    private static void muotoileOtsake(StringBuilder sb, String tyyppi) {
        sb.append("@");
        sb.append(tyyppi);
        sb.append("{\n");
    }
    
    private static void muotoileKentat(StringBuilder sb, Map<String, String> koodaus) {
        for (String kentta : koodaus.keySet()) {
            if (koodaus.get(kentta) == null) {
                continue;
            }
            
            sb.append(kentta);
            sb.append(" = {");
            sb.append(korjaaMuotoilu(koodaus.get(kentta)));
            sb.append("},\n");
        }
    }
    
    private static String korjaaMuotoilu(String merkkijono) {
        // näistä pitäisi myöhemmin tehdä esim. HashMap
        merkkijono = merkkijono.replaceAll("ä", "\\\\\"{a}");
        merkkijono = merkkijono.replaceAll("ö", "\\\\\"{o}");
        
        merkkijono = merkkijono.replaceAll("#", "\\\\#");
        merkkijono = merkkijono.replaceAll("%", "\\\\%");
        merkkijono = merkkijono.replaceAll("&", "\\\\&");
        
        return merkkijono;
    }
    
}
