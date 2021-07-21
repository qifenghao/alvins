package org.alvin.app01.streamoperation;

public class Averager {
    private int total;
    private int count;

    public int getTotal() {
        return total;
    }

    public double average() {
        return count > 0 ? (double) total / count : 0;
    }

    public void accept(int i) {
        total += i;
        count++;
    }

    public void combine(Averager other) {
        total += other.total;
        count += other.count;
    }
}
