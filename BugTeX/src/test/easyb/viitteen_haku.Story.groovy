import bugtex.*;
import bugtex.kayttoliittyma.*;
import bugtex.tietokanta.*;
import bugtex.IO.*;

description 'Käyttäjä voi rajata viitteitä kenttien sisällön mukaan'

scenario 'oikealla tekstikomennolla käyttäjä pääsee hakemaan vitteitä', {
    given 'annettu komento Hae viitteen lisäyksen jälkeen', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("lisaa", "kirja", "Tekija", "Nimi", "Julkaisija", "Vuosi", "Hae", "nimi", "Nimi")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'hakuehdot on annettu', {
        ui.run()
    }

    then 'viitteen tiedot tulostuvat käyttäjän tarkasteltavaksi', {
        lukija.getTulostukset().shouldHave("tunnus: tekijaVuosinimi" + "\n" + "tekijä: Tekija" + "\n" +
                                           "nimi: Nimi" + "\n" + "julkaisija: Julkaisija" + "\n" +
                                           "vuosi: Vuosi" + "\n")
    }
}

scenario 'oikealla numerokomennolla käyttäjä pääsee hakemaan vitteitä', {
    given 'annettu komento Hae viitteen lisäyksen jälkeen', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("1", "kirja", "Tekija", "Nimi", "Julkaisija", "Vuosi", "Hae", "nimi", "Nimi")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'hakuehdot on annettu', {
        ui.run()
    }

    then 'viitteen tiedot tulostuvat käyttäjän tarkasteltavaksi', {
        lukija.getTulostukset().shouldHave("tunnus: tekijaVuosinimi" + "\n" + "tekijä: Tekija" + "\n" +
                                           "nimi: Nimi" + "\n" + "julkaisija: Julkaisija" + "\n" +
                                           "vuosi: Vuosi" + "\n")
    }
}

scenario 'haku, joka ei täsmää viitteeseen, ei tulosta viitteen tietoja', {
    given 'annettu komento Hae joka ei täsmää lisättyyn viitteeseen', {
        db = new MuistiTietokanta()
       lukija = new Valelukija("lisaa", "kirja", "Tekija", "Nimi", "Julkaisija", "Vuosi", "Hae", "nimi", "AA")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'hakuehdot on annettu', {
        ui.run()
    }

    then 'viitteen tiedot eivät tulostu käyttäjän tarkasteltaviksi', {
        lukija.getTulostukset().shouldNotHave("Hakemaasi viitettä ei löytynyt!")
    }
}
