import bugtex.*;
import bugtex.kayttoliittyma.*;
import bugtex.tietokanta.*;
import bugtex.IO.*;

description 'Käyttäjä voi lisätä viitteen järjestelmään'

scenario 'oikealla komennolla käyttäjä pääsee lisäämään viitteen', {
    given 'annettu komento Lisaa', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("lisaa", "kirja", "Tekija", "Nimi", "Julkaisija", "Vuosi")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'tiedot on syötetty', {
        ui.run()
    }

    then 'viitteen lisäys onnistuu', {
        lukija.getTulostukset().shouldHave("Viitteen lisäys onnistui")
    }
}

scenario 'Käyttäjä voi lisätä artikkeli viitteen', {
    given 'Käyttäjän antaessa lisää komennon artikkelille', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("lisaa", "artikkeli", "Marko", "Seikkailut", "Modern Times", "2000", "3", "poistu")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'ohjelma kysyy käyttäjältä artikkelin tiedot', {
        ui.run()
    }

    then 'jonka jälkeen ohjelma tallentaa artikkelin ja ilmoittaa siitä käyttäjälle', {
        lukija.getTulostukset().shouldHave("Viitteen lisäys onnistui")
    }
}

