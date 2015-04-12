import bugtex.idgen.*
import bugtex.kayttoliittyma.*
import bugtex.komento.*
import bugtex.lukija.*
import bugtex.tietokanta.*
import bugtex.viite.*

description 'Käyttäjä voi lisätä viitteen järjestelmään'

scenario 'oikealla komennolla käyttäjä pääsee lisäämään viitteen', {
    given 'annettu komento Lisaa'
    then 'käyttäjältä kysytään syotettävät tiedot'
    and 'käyttäjän syöttämien tietojen pohjalta luodaan viite'
}

scenario 'virheellisellä komennolla käyttäjälle listataan käytettävät komennot', {
    given 'annettu komento jota järjestelmä ei tunne'
    then 'käyttäjälle näytetään lista käytössä olevista komennoista'
}



