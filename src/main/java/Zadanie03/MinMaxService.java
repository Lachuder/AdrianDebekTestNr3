package Zadanie03;

import java.util.*;

public class MinMaxService {

    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {

        T min = elements.stream()
                .min(Comparator.naturalOrder())
                .orElseThrow();

        T max = elements.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow();

        return new MinMax<>(max, min);
    }

}
