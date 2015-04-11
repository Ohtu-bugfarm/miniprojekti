package bugtex.main;

import bugtex.kayttoliittyma.TekstiKayttoliittyma;
import bugtex.lukija.Lukija;
import bugtex.lukija.Syotteenlukija;

public class Main {

    private static Lukija lukija;
    private static TekstiKayttoliittyma UI;

    public Main(Lukija lukija) {
        this.lukija = lukija;
        UI = new TekstiKayttoliittyma(lukija);
    }

    public void run() {
        UI.run();
    }

    public static void main(String[] args) {
        lukija = new Syotteenlukija();
        UI = new TekstiKayttoliittyma(lukija);
        UI.run();
    }

}
