package baseball.util;

import java.util.ArrayList;

public class CustomList<E> extends ArrayList {
    @Override
    public boolean add(Object o) {
        if(this.contains(o)) return false;
        return super.add(o);
    }
}
