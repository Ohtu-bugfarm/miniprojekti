import bugtex.*;
import bugtex.kayttoliittyma.*;
import bugtex.tietokanta.*;
import bugtex.IO.*;


scenario 'Kun käyttäjä antaa tyhjän komennon ohjelma ei kaadu', {
    given 'Käyttäjältä kysytään syöte', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("")
        ui = new TekstiKayttoliittyma(lukija, db)
    }
    
    when 'Käyttäjä antaa tyhjän syötteen', {
        ui.run()
    }
    
    then 'jolloin ohjelma ilmoittaa tuntemattomasta komennosta', {
        lukija.getTulostukset().shouldHave("Ohjelma tuntee komennot lisaa, poista, tarkastele, bibtex, listaa, poistu, help")
    }
}

scenario 'Kun käyttäjä ei tiedä komentoja hän voi pyytää listaa komennoista, jolloin ohjelma palauttaa listan', {
    given 'Käyttäjältä kysytään syötettä', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("")
        ui = new TekstiKayttoliittyma(lukija, db)
    }
    
    when 'jolloin hän pyytää listaa komennoista', {
        ui.run()
    }
    
    then 'jolloin ohjelma ohjelma palauttaa listan sen tuntemista komennoista', {
        lukija.getTulostukset().shouldHave("Ohjelma tuntee komennot lisaa, poista, tarkastele, bibtex, listaa, poistu, help")
    }
}
