package bugtex.viite;

import java.io.Serializable;
import java.util.Map;

/**
 * Rajapinta viitteelle
 */
public interface Viite extends Serializable {

    String getTunnus();

    Map<String, String> getKyselyt();

    /**
     * Palauttaa viitteen BiBTeX-formaatissa käytetyn tyypin
     *
     * @return BiBTeX-tyyppi merkkijonona
     */
    String getTyyppi();

    /**
     * Palauttaa map-rakenteessa BiBTeX-koodaukessa tarvittavat kentät
     *
     * @return kentat map-rakenteessa
     */
    Map<String, String> koodaus();

}
