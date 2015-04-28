import bugtex.*;
import bugtex.kayttoliittyma.*;
import bugtex.tietokanta.*;
import bugtex.IO.*;

description 'Käyttäjä voi listata kaikki viitteet järjestelmässä'

scenario 'oikealla komennolla käyttäjä pääsee listaamaan lisätyt viitteet', {
    given 'annettu komento Lisaa', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("lisaa", "kirja", "Tekija1", "Nimi", "Julkaisija", "Vuosi", "Listaa")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'tiedot on syötetty', {
        ui.run()
    }

    then 'listaus onnistuu', {
        lukija.getTulostukset().shouldHave("tunnus: tekija1Vuosinimi")
    }
}
