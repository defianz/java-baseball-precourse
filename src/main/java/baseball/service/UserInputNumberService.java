package baseball.service;

import baseball.object.ThreeNumber;

public interface UserInputNumberService {
    public ThreeNumber userInputNumber();

    public boolean validateNumber(String input);
}