package Zadanie01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SzafaTest {

    Szafa szafa;

    @BeforeEach
    void init() {

        szafa = new Szafa();

    }

    @Test
    void shouldAddClothesToWardrobe() {
        szafa.dodajUbranie(new Ubranie("Jeans", Rozmiar.L, 50.0));
        File file = new File("szafa.txt");

        Assertions.assertTrue(file.exists());
        Assertions.assertTrue(file.length() > 0);
    }

    @Test
    void shouldCreatATextFile() {

        File file = new File("szafa.txt");

        Assertions.assertTrue(file.exists());
    }

    @Test
    void shouldReturnList() {

        Assertions.assertInstanceOf(List.class, szafa.getUbrania());

    }

    @Test
    void shouldReturnTrueWhenWardrobeHasClothesInside() {

        szafa.dodajUbranie(new Ubranie("Jeans", Rozmiar.L, 50.0));

        Iterator<Ubranie> iterator = szafa.getUbrania().iterator();

        assertTrue(iterator.hasNext());
    }

    @Test
    void shouldThrowNoSuchElementExceptionWhenWardrobeIsEmpty() {

        Iterator<Ubranie> iterator = szafa.getUbrania().iterator();
        Exception e = assertThrows(NoSuchElementException.class, iterator::next);

        Assertions.assertEquals(NoSuchElementException.class, e.getClass());

    }

}