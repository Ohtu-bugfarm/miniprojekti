package bugtex.viite;

import java.io.Serializable;
import java.util.Map;

/**
 * Rajapinta viitteelle.
 */
public interface Viite extends Serializable {

    /**
     * Hae viitteen tunnus
     *
     * @return viitteen tunnus
     */
    String getTunnus();

    /**
     * Palauttaa viitteen kentät ja niiden arvot mappina
     * @return map kentistä ja niiden arvoista
     */
    Map<String, String> getKyselyt();

    /**
     * Palauttaa viitteen BiBTeX-formaatissa käytetyn tyypin.
     *
     * @return BiBTeX-tyyppi merkkijonona
     */
    String getTyyppi();

    /**
     * Palauttaa map-rakenteessa BiBTeX-koodaukessa tarvittavat kentät.
     *
     * @return kentat map-rakenteessa
     */
    Map<String, String> koodaus();

}
