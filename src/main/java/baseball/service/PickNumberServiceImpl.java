package baseball.service;

import baseball.object.ThreeNumber;
import baseball.util.CustomList;
import nextstep.utils.Randoms;

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
        CustomList<Integer> customList = new CustomList();
        while(customList.size() != 3 ){
            customList.add(Randoms.pickNumberInRange(1, 9));
        }

        // 성능 개선을 위해 CustomList를 좀더 바꿔야할수도..?
        return new ThreeNumber((int)customList.get(0), (int)customList.get(1), (int)customList.get(2));
    }

}

