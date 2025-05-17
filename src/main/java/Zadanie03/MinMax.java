package Zadanie03;

public class MinMax<T extends Comparable<T>> {

    private T max;
    private T min;

    public MinMax(T max, T min) {
        this.max = max;
        this.min = min;
    }

    public T getMax() {
        return max;
    }

    public T getMin() {
        return min;
    }

    @Override
    public String toString() {
        return "MinMax{" +
                "max=" + max +
                ", min=" + min +
                '}';
    }

}
