import bugtex.*;
import bugtex.kayttoliittyma.*;
import bugtex.tietokanta.*;
import bugtex.IO.*;

description 'Käyttäjä voi tarkastella lisättyä viitettä järjestelmässä'

scenario 'oikealla komennolla käyttäjä pääsee tarkastelemaan viitettä', {
    given 'annettu komento Tarkastele viitteen lisäyksen jälkeen', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("Lisaa", "kirja", "Tekija", "Nimi", "Julkaisija", "Vuosi", "Tarkastele", "1")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'viitteen id on annettu', {
        ui.run()
    }

    then 'viitteen tiedot tulostuvat käyttäjän tarkasteltavaksi', {
        lukija.getTulostukset().shouldHave("tunnus: 1" + "\n" + "tekijä: Tekija" + "\n" +
                                           "nimi: Nimi" + "\n" + "julkaisija: Julkaisija" + "\n" +
                                           "vuosi: Vuosi" + "\n")
    }
}

scenario 'väärällä id:llä tarkastelu tuottaa virheilmoituksen', {
    given 'annettu komento Tarkastele id:llä jota ei ole olemassa', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("Tarkastele", "3")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'olematon id on annettu', {
        ui.run()
    }

    then 'viitteen tulostus ei onnistu', {
        lukija.getTulostukset().shouldHave("Hakemaasi viitettä ei löytynyt!")
    }
}
