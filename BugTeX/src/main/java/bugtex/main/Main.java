package bugtex.main;

import bugtex.kayttoliittyma.TekstiKayttoliittyma;
import bugtex.lukija.Syotteenlukija;

public class Main {
    
    public static void main(String[] args) {
        Syotteenlukija lukija = new Syotteenlukija(); 
        TekstiKayttoliittyma UI = new TekstiKayttoliittyma(lukija);
        UI.run();
    }
    
}
