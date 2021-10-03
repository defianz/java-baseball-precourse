package baseball.service;

import baseball.object.ThreeNumber;
import nextstep.utils.Randoms;

public class PickNumberServiceImpl implements PickNumberService {


    private static final PickNumberServiceImpl pickNumber = new PickNumberServiceImpl();

    public static PickNumberServiceImpl getInstance() {
        return pickNumber;
    }

    @Override
    public ThreeNumber pickNumber() {
        ThreeNumber threeNumber = new ThreeNumber(Randoms.pickNumberInRange(1, 9), Randoms.pickNumberInRange(1, 9), Randoms.pickNumberInRange(1, 9));
        return threeNumber;
    }
}

