package baseball.service;

import baseball.object.ThreeNumber;

public class CompareNumberServiceImpl implements CompareNumberService {

    private static final CompareNumberServiceImpl compareNumberService = new CompareNumberServiceImpl();

    public static CompareNumberServiceImpl getInstance() {
        return compareNumberService;
    }

    @Override
    public boolean compareNumber(ThreeNumber com, ThreeNumber user) {
        int strike = calculateStrike(com, user);
        int ball = calculateBall(com, user);
        printResult(strike, ball);
        if (strike == 3) return true;
        return false;
    }

    private void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) System.out.println("낫싱");
        String result = strike == 0 ? "" : strike + "스트라이크 ";
        result += ball == 0 ? "" : ball + "볼";
        System.out.println(result);
    }

    private int calculateBall(ThreeNumber com, ThreeNumber user) {
        int ball = 0;
        if (com.getNumberIndex(user.getFirst()) != -1 && com.getNumberIndex(user.getFirst()) != 1) ball++;
        if (com.getNumberIndex(user.getSecond()) != -1 && com.getNumberIndex(user.getSecond()) != 2) ball++;
        if (com.getNumberIndex(user.getThird()) != -1 && com.getNumberIndex(user.getThird()) != 3) ball++;
        return ball;
    }

    private int calculateStrike(ThreeNumber com, ThreeNumber user) {
        int strike = 0;
        if (com.getFirst() == user.getFirst()) strike++;
        if (com.getSecond() == user.getSecond()) strike++;
        if (com.getThird() == user.getThird()) strike++;
        return strike;
    }
}
