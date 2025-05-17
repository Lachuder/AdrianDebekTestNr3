package Zadanie01;

public class Ubranie implements Comparable<Ubranie> {

    private String nazwa;
    private Rozmiar rozmiar;
    private double cena;
    private static Kryterium kryterium = Kryterium.ROZMIAR;

    public Ubranie(String nazwa, Rozmiar rozmiar, double cena) {
        this.nazwa = nazwa;
        this.rozmiar = rozmiar;
        this.cena = cena;
    }

    public static Kryterium getKryterium() {
        return kryterium;
    }

    public static void ustalKryteriumSortowania(Kryterium nowe) {
        kryterium = nowe;
    }

    @Override
    public String toString() {
        return nazwa + " " + rozmiar + " " + cena;
    }

    @Override
    public int compareTo(Ubranie o) {
        return switch (kryterium) {
            case ROZMIAR -> Integer.compare(this.rozmiar.ordinal(), o.rozmiar.ordinal());
            case WARTOSC -> Integer.compare((int) this.cena, (int) o.cena);
        };
    }
}
