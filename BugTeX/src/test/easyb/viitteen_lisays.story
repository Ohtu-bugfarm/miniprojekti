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

scenario 'käyttäjältä kysytään viitteen tyypin mukaiset tiedot', {
    given 'annettu hyväksyttävä viitetyyppi'
    then 'käyttäjää pyydetään syöttämään viitteen tiedot'
}

scenario 'virheellisellä komennolla käyttäjälle listataan käytettävät komennot', {
    given 'annettu komento jota järjestelmä ei tunne'
    then 'käyttäjälle näytetään lista käytössä olevista komennoista'
}



