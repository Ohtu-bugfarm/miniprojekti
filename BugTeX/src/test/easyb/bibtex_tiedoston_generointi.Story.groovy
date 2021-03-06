import bugtex.*;
import bugtex.kayttoliittyma.*;
import bugtex.tietokanta.*;
import bugtex.IO.*;


scenario 'Kun käyttäjä yrittää generoida .bib tiedostoa ilman viitteitä ohjelma huomaa tämän ja ilmoittaa viitteiden puuttumisesta', {
    given 'Käyttäjän pyytäessä ohjelmaa generoimaan .bib tiedoston', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("generoiBibtex", "test", "poistu")
        ui = new TekstiKayttoliittyma(lukija, db)
    }
    
    when 'Ohjelma pyrkii tekemään tiedoston', {
        ui.run()
    }
    
    then 'mutta huomaa ettei käyttäjällä ole yhtään viitettä ja ilmoittaa siitä', {
        lukija.getTulostukset().shouldHave("Sinulla ei ole yhtään viitettä talletettuna")
    }
}

scenario 'Kun käyttäjä yrittää generoida .bib tiedostoa generoi ohjelma tiedoston onnistuneesti', {
    given 'Käyttäjän pyytäessä ohjelmaa generoimaan .bib tiedoston', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("lisaa", "kirja", "a", "b", "c", "d", "generoiBibtex", "test", "poistu")
        ui = new TekstiKayttoliittyma(lukija, db)
    }
    
    when 'Ohjelma pyrkii tekemään tiedoston', {
        ui.run()
    }
    
    then 'Onnistuessaan generoimaan .bib tiedoston ohjelma ilmoittaa siitä', {
        lukija.getTulostukset().shouldHave("Generointi onnistui")
    }
}


