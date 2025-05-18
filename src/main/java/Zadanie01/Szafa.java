package Zadanie01;

import java.io.*;
import java.util.*;

public class Szafa implements Iterable<Ubranie> {

    private static final String FILE_NAME = "szafa.txt";

    public Szafa() {
        stworzPlikTekstowySzafa();
    }

    private void stworzPlikTekstowySzafa() {
        try {
            FileWriter fw = new FileWriter("szafa.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dodajUbranie(Ubranie...ubrania) {
        try (
                FileWriter fw = new FileWriter(FILE_NAME, true);
                BufferedWriter bw = new BufferedWriter(fw);
                ){
            bw.write(Arrays.toString(ubrania)
                    .replace("[", "")
                    .replace("]", "")
                    .replace(", ", "\n"));
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Ubranie> getUbrania() {
        List<Ubranie> result = Collections.emptyList();
        try (
                FileReader fr = new FileReader(FILE_NAME);
                BufferedReader br = new BufferedReader(fr);
                ) {
            result = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                result.add(getObiektUbranieNaDanychZPliku(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Ubranie getObiektUbranieNaDanychZPliku(String input) {
        String[] temp = input.replaceAll("\\s+", " ").split(" ");
        String nazwa = temp[0];
        Rozmiar rozmiar = Rozmiar.valueOf(temp[1]);
        double cena = Double.parseDouble(temp[2]);
        return new Ubranie(nazwa, rozmiar, cena);
    }

    @Override
    public Iterator<Ubranie> iterator() {
        return new UbranieIterator();
    }

    private class UbranieIterator implements Iterator<Ubranie> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < getUbrania().size();
        }

        @Override
        public Ubranie next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return getUbrania().get(index++);
        }
    }

}
