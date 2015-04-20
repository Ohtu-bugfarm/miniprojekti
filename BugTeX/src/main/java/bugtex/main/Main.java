package bugtex.main;

import bugtex.kayttoliittyma.TekstiKayttoliittyma;
import bugtex.IO.Syotteenlukija;
import bugtex.tietokanta.TiedostoTietokanta;
import bugtex.tietokanta.TietokantaRajapinta;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Syotteenlukija lukija = new Syotteenlukija();
        TietokantaRajapinta db = new TiedostoTietokanta("src/main/resources/viitteet.db");
        TekstiKayttoliittyma UI = new TekstiKayttoliittyma(lukija, db);
        UI.run();
    }

}
