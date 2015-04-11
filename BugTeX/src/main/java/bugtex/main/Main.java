package bugtex.main;

import bugtex.kayttoliittyma.TekstiKayttoliittyma;
import bugtex.IO.Syotteenlukija;
import bugtex.tietokanta.MuistiTietokanta;
import bugtex.tietokanta.TietokantaRajapinta;

public class Main {
    
    public static void main(String[] args) {
        Syotteenlukija lukija = new Syotteenlukija();
        TietokantaRajapinta db = new MuistiTietokanta();
        TekstiKayttoliittyma UI = new TekstiKayttoliittyma(lukija, db);
        UI.run();
    }
    
}
