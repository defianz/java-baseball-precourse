package baseball.service;

import baseball.object.ThreeNumber;

public interface UserInputNumberService {
    ThreeNumber userInputNumber();

    boolean validateNumber(String input);
}