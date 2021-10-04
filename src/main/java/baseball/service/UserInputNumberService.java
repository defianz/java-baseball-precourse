package baseball.service;

import baseball.object.ThreeNumber;

public interface UserInputNumberService {
    ThreeNumber inputUserNumber();

    boolean validateNumber(String input);
}