import bugtex.*;
import bugtex.kayttoliittyma.*;
import bugtex.tietokanta.*;
import bugtex.IO.*;

description 'Käyttäjä voi listata kaikki viitteet järjestelmässä'

scenario 'oikealla komennolla käyttäjä pääsee listaamaan lisätyt viitteet BibTeX-muodossa', {
    given 'annettu komento Lisaa', {
        db = new MuistiTietokanta()
<<<<<<< HEAD
        lukija = new Valelukija("Lisaa", "Tekija1", "Nimi", "Julkaisija", "Vuosi", "Lisaa", "Tekija2", "Nimi2", "Julkaisija2", "Vuosi2", "Bibtexlist")
=======
        lukija = new Valelukija("lisaa", "kirja", "1", "Tekija1", "Nimi", "Julkaisija", "Vuosi",
                                "lisaa", "kirja", "2", "Tekija2", "Nimi2", "Julkaisija2", "Vuosi2", "listaaBibtex")
>>>>>>> 9f2fff9b73fbc9ca859cb08b7a46b2c11cc0ae98
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'tiedot on syötetty', {
        ui.run()
    }

    then 'listaus onnistuu', {
        lukija.getTulostukset().shouldHave("author = {Tekija1},")
        and
        lukija.getTulostukset().shouldHave("author = {Tekija2},")
<<<<<<< HEAD
        
=======
>>>>>>> 9f2fff9b73fbc9ca859cb08b7a46b2c11cc0ae98
    }
}

scenario 'jos viitteitä ei ole, käyttäjälle näytetään ilmoitus', {
    given 'annettu komento Bibtexlist tyhjällä listalla', {
        db = new MuistiTietokanta()
<<<<<<< HEAD
        lukija = new Valelukija("Bibtexlist")
=======
        lukija = new Valelukija("listaaBibtex")
>>>>>>> 9f2fff9b73fbc9ca859cb08b7a46b2c11cc0ae98
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'komento annettu', {
        ui.run()
    }

    then 'viitteitä ei löydy ja käyttäjälle ilmoitetaan siitä', {
        lukija.getTulostukset().shouldHave("Viitteitä ei löytynyt")
    }
}