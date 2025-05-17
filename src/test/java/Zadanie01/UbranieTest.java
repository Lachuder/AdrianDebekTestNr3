package Zadanie01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static Zadanie01.Kryterium.WARTOSC;
import static Zadanie01.Kryterium.valueOf;

class UbranieTest {

    @Test
    void shouldChangeCryteriumToWartosc() {

        Ubranie.ustalKryteriumSortowania(WARTOSC);
        Assertions.assertEquals(WARTOSC, Ubranie.getKryterium());

    }
}