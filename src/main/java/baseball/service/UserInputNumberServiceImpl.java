package baseball.service;

import baseball.object.ThreeNumber;
import nextstep.utils.Console;

public class UserInputNumberServiceImpl implements UserInputNumberService {

    private static final UserInputNumberServiceImpl userInputNumber = new UserInputNumberServiceImpl();

    public static UserInputNumberServiceImpl getInstance() {
        return userInputNumber;
    }

    @Override
    public ThreeNumber userInputNumber() {
        String inputObj = Console.readLine();
        while (!validateNumber(inputObj)) {
            inputObj = Console.readLine();
        }
        return makeInputObjToThreeNumber(inputObj);
    }

    private ThreeNumber makeInputObjToThreeNumber(String inputObj) {
        return new ThreeNumber(
                Integer.parseInt(inputObj.charAt(0) + ""),
                Integer.parseInt(inputObj.charAt(1) + ""),
                Integer.parseInt(inputObj.charAt(2) + "")
        );
    }

    @Override
    public boolean validateNumber(String input) {
        // 사이즈 체크
        if (input.length() != 3) {
            System.out.println("[ERROR] 1-9 로 이루어진 세자리 숫자를 입력해주세요.");
            return false;
        }

        // 1-9 숫자 체크
        String REGEX = "^[1-9]+$";
        if (!input.matches(REGEX)) {
            System.out.println("[ERROR] 1-9 로 이루어진 세자리의 올바른 수를 입력해주세요.");
            return false;
        }
        return true;
    }
}
