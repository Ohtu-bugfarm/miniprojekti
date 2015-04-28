import bugtex.*;
import bugtex.kayttoliittyma.*;
import bugtex.tietokanta.*;
import bugtex.IO.*;

description 'Käyttäjä voi poistaa lisätyn viiteen'

scenario 'oikealla komennolla käyttäjä pääsee poistamaan viitteen', {
    given 'annettu komento Poista viitteen lisäyksen jälkeen', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("lisaa", "kirja", "Tekija", "Nimi", "Julkaisija", "Vuosi", "poista", "1")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'viitteen id on annettu', {
        ui.run()
    }

    then 'poisto ilmoitetaan onnistuneeksi', {
        lukija.getTulostukset().shouldHave("Poistettiin viite tekijaVuosinimi")
    }
}

scenario 'väärällä id:llä poisto tuottaa virheilmoituksen', {
    given 'annettu komento Poista id:llä jota ei ole olemassa', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("poista", "2")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'olematon id on annettu', {
        ui.run()
    }

    then 'viitteen poisto ei onnistu', {
        lukija.getTulostukset().shouldHave("Poisto ei onnistunut")
    }
}
