
description 'Käyttäjä voi lisätä viitteen järjestelmään'

scenario 'oikealla komennolla käyttäjä pääsee lisäämään viitteen', {
    given 'annettu komento lisaa'
    then 'käyttäjälle näytetään järjestelmän tuntemat viitetyypit'
    and 'käyttäjältä kysytään lisättävän viitteen tyyppi'
}

scenario 'käyttäjältä kysytään viitteen tyypin mukaiset tiedot', {
    given 'annettu hyväksyttävä viitetyyppi'
    then 'käyttäjää pyydetään syöttämään viitteen tiedot'
}

scenario 'virheellisellä komennolla käyttäjälle listataan käytettävät komennot', {
    given 'annettu komento jota järjestelmä ei tunne'
    then 'käyttäjälle näytetään lista käytössä olevista komennoista'
}



