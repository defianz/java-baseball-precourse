package baseball.service;

import baseball.object.ThreeNumber;
import nextstep.utils.Randoms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PickNumberServiceImpl implements PickNumberService {


    private static final PickNumberServiceImpl pickNumber = new PickNumberServiceImpl();

    public static PickNumberServiceImpl getInstance() {
        return pickNumber;
    }

    @Override
    public ThreeNumber pickNumber() {
        ThreeNumber threeNumber = makeComputerNumber();
        return threeNumber;
    }

    private ThreeNumber makeComputerNumber() {
        Set<Integer> validate = new HashSet<>();
        while(validate.size() != 3){
            validate.add(Randoms.pickNumberInRange(1,9));
        }
        Iterator<Integer> it = validate.iterator();
        return new ThreeNumber(it.next(),it.next(),it.next());
    }
}

