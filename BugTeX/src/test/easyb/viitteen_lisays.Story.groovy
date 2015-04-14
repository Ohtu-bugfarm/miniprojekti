import bugtex.*;
import bugtex.kayttoliittyma.*;
import bugtex.tietokanta.*;
import bugtex.IO.*;

description 'Käyttäjä voi lisätä viitteen järjestelmään'

scenario 'oikealla komennolla käyttäjä pääsee lisäämään viitteen', {
    given 'annettu komento Lisaa', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("Lisaa", "Tekija", "Nimi", "Julkaisija", "Vuosi")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'tiedot on syötetty', {
        ui.run()
    }

    then 'viitteen lisäys onnistuu', {
        lukija.getTulostukset().shouldHave("Kirjan lisäys onnistui")
    }
}

scenario 'kirjaa ei lisätä jos käyttäjä keskeyttää toiminnon', {
    given 'käyttäjä keskeyttää toiminnan kesken lisäyksen', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("Lisaa", "Tekija", "Keskeyta")
        ui = new TekstiKayttoliittyma(lukija, db)
    }
    
    when 'toiminta keskeytetään', {
        ui.run()
    }
    
    then 'kirjan lisäys ei onnistu', {
        lukija.getTulostukset().shouldNotHave("Kirjan lisäys onnistui")
    }
}

scenario 'virheellisellä komennolla käyttäjälle listataan mahdolliset komennot', {
    given 'käyttäjä antaa komennon jota järjestelmä ei tunne', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("Foo")
        ui = new TekstiKayttoliittyma(lukija, db)
    }
    
    when 'virheellinen komento annettu', {
        ui.run()
    }
    
    then 'käyttäjälle näytetään lista käytössä olevista komennoista', {
        lukija.getTulostukset().shouldHave("Ohjelma tuntee komennot Lisaa, Poista, Tarkastele, Bibtex, Listaa, Poistu, Help")
    }
}
