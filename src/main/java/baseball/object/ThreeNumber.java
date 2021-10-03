package baseball.object;

import java.util.HashMap;

public class ThreeNumber {

    private final int first;
    private final int second;
    private final int third;

    private final HashMap<Integer, Integer> hm = new HashMap<>();

    public ThreeNumber(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
        hm.put(first, 1);
        hm.put(second, 2);
        hm.put(third, 3);
    }

    public int getNumberIndex(int searchNumber) {
        if (hm.containsKey(searchNumber)) return hm.get(searchNumber);
        return -1;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }
}
