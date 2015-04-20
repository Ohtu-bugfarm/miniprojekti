import bugtex.*;
import bugtex.kayttoliittyma.*;
import bugtex.tietokanta.*;
import bugtex.IO.*;

description 'Käyttäjä voi lisätä viitteen järjestelmään'

scenario 'oikealla komennolla käyttäjä pääsee lisäämään viitteen', {
    given 'annettu komento Lisaa', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("lisaa", "kirja", "1", "Tekija", "Nimi", "Julkaisija", "Vuosi")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'tiedot on syötetty', {
        ui.run()
    }

    then 'viitteen lisäys onnistuu', {
        lukija.getTulostukset().shouldHave("Viitteen lisäys onnistui")
    }
}

scenario 'kirjaa ei lisätä jos käyttäjä keskeyttää toiminnon', {
    given 'käyttäjä keskeyttää toiminnan kesken lisäyksen', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("lisaa", "kirja", "1", "Tekija", "Keskeyta")
        ui = new TekstiKayttoliittyma(lukija, db)
    }
    
    when 'toiminta keskeytetään', {
        ui.run()
    }
    
    then 'kirjan lisäys ei onnistu', {
        lukija.getTulostukset().shouldNotHave("Viitteen lisäys onnistui")
    }
}

scenario 'virheellisellä komennolla käyttäjälle listataan mahdolliset komennot', {
    given 'käyttäjä antaa komennon jota järjestelmä ei tunne', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("foo")
        ui = new TekstiKayttoliittyma(lukija, db)
    }
    
    when 'virheellinen komento annettu', {
        ui.run()
    }
    
    then 'käyttäjälle näytetään lista käytössä olevista komennoista', {
<<<<<<< HEAD
        lukija.getTulostukset().shouldHave("Ohjelma tuntee komennot Lisaa, Poista, Tarkastele, Bibtex, Listaa, Bibtexlist, Poistu, Help")
=======
        lukija.getTulostukset().shouldHave("Ohjelma tuntee komennot lisaa, poista, " +
                                           "tarkastele, bibtex, listaa, listaaBibtex, " +
                                           "generoiBibtex, poistu, help")
>>>>>>> 9f2fff9b73fbc9ca859cb08b7a46b2c11cc0ae98
    }
}
