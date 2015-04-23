import bugtex.*;
import bugtex.kayttoliittyma.*;
import bugtex.tietokanta.*;
import bugtex.IO.*;

description 'Käyttäjä voi muokata viitettä'

scenario 'oikealla komennolla käyttäjä pääsee muokkaamaan viitettä', {
    given 'annettu komento Lisaa', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("lisaa", "kirja", "Tekija", "Nimi", "Julkaisija", "Vuosi",
                                "muokkaa", "tekijaVuosinimi", "1", "2", "listaa")
        ui = new TekstiKayttoliittyma(lukija, db)
    }

    when 'tiedot on syötetty', {
        ui.run()
    }

    then 'viitteen muokkaus onnistuu', {
        lukija.getTulostukset().shouldHave("tunnus: 2")
    }
}

scenario 'viitettä ei muokata jos annetun kentän numero on virheellinen', {
    given 'käyttäjä keskeyttää toiminnan kesken muokkauksen', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("lisaa", "kirja", "Tekija", "Nimi", "Julkaisija", "Vuosi",
                                "muokkaa", "tekijaVuosinimi", "0", "2")
        ui = new TekstiKayttoliittyma(lukija, db)
    }
    
    when 'annetaan virheellinen kenttä', {
        ui.run()
    }
    
    then 'viitteen muokkaus ei onnistu', {
        lukija.getTulostukset().shouldHave("Virheellinen kenttä!")
    }
}

scenario 'viitettä ei muokata jos annettu viitteen tunnus on virheellinen', {
    given 'käyttäjä keskeyttää toiminnan kesken lisäyksen', {
        db = new MuistiTietokanta()
        lukija = new Valelukija("lisaa", "kirja", "Tekija", "Nimi", "Julkaisija", "Vuosi",
                                "muokkaa", "1")
        ui = new TekstiKayttoliittyma(lukija, db)
    }
    
    when 'annetaan virheellinen kenttä', {
        ui.run()
    }
    
    then 'viitteen muokkaus ei onnistu', {
        lukija.getTulostukset().shouldHave("Hakemaasi viitettä ei löytynyt!")
    }
}
