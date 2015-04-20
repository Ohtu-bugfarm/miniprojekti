import bugtex.*;
import bugtex.kayttoliittyma.*;
import bugtex.tietokanta.*;
import bugtex.IO.*;

description 'Käyttäjä voi tarkastella lisättyä viitettä BibTeX-muodossa'

scenario 'oikealla komennolla käyttäjä pääsee tarkastelemaan viitettä BibTeX-muodossa', {
    given 'annettu komento Bibtex viitteen lisäyksen jälkeen', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("lisaa", "kirja", "1", "Tekija1", "Nimi", "Julkaisija", "Vuosi", "Bibtex", "1")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'viitteen id on annettu', {
        ui.run()
    }

    then 'viitteen tiedot tulostuvat käyttäjän tarkasteltavaksi', {
        lukija.getTulostukset().shouldHave("author = {Tekija1},")
    }
}

scenario 'väärällä id:llä tarkastelu tuottaa virheilmoituksen', {
    given 'annettu komento Tarkastele id:llä jota ei ole olemassa', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("bibtex", "3")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'olematon id on annettu', {
        ui.run()
    }

    then 'viitteen tulostus ei onnistu', {
        lukija.getTulostukset().shouldHave("Hakemaasi viitettä ei löytynyt!")
    }
}
