package Zadanie01;

import java.util.Collections;

public class Runner01 {

    public static void main(String[] args) {

        Szafa szafa = new Szafa();

        Ubranie u1 = new Ubranie("Koszula", Rozmiar.XL, 100.0);
        Ubranie u2 = new Ubranie("Majtki", Rozmiar.M, 20.0);
        Ubranie u3 = new Ubranie("Jeansy", Rozmiar.L, 330.0);
        Ubranie u4 = new Ubranie("Kurtka", Rozmiar.XS, 250.0);
        Ubranie u5 = new Ubranie("Buty", Rozmiar.S, 150.0);


        szafa.dodajUbranie(u1);
        szafa.dodajUbranie(u1, u2);
        szafa.dodajUbranie(u1, u2, u3);

        for(Ubranie u : szafa) {
        }

        Ubranie najwieksze = Collections.max(szafa.getUbrania());
        Ubranie.ustalKryteriumSortowania(Kryterium.WARTOSC);
        Ubranie najdrozsze = Collections.max(szafa.getUbrania());

    }

}
