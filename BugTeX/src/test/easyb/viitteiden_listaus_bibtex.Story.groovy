import bugtex.*;
import bugtex.kayttoliittyma.*;
import bugtex.tietokanta.*;
import bugtex.IO.*;

description 'Käyttäjä voi listata kaikki viitteet järjestelmässä'

scenario 'oikealla komennolla käyttäjä pääsee listaamaan lisätyt viitteet BibTeX-muodossa', {
    given 'annettu komento Lisaa', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("Lisaa", "Tekija1", "Nimi", "Julkaisija", "Vuosi", "Lisaa", "Tekija2", "Nimi2", "Julkaisija2", "Vuosi2", "Bibtexlist")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'tiedot on syötetty', {
        ui.run()
    }

    then 'listaus onnistuu', {
        lukija.getTulostukset().shouldHave("author = {Tekija1},")
        and
        lukija.getTulostukset().shouldHave("author = {Tekija2},")
        
    }
}

scenario 'jos viitteitä ei ole, käyttäjälle näytetään ilmoitus', {
    given 'annettu komento Bibtexlist tyhjällä listalla', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("Bibtexlist")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'komento annettu', {
        ui.run()
    }

    then 'viitteitä ei löydy ja käyttäjälle ilmoitetaan siitä', {
        lukija.getTulostukset().shouldHave("Viitteitä ei löytynyt")
    }
}