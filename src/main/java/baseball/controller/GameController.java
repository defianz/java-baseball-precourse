package baseball.controller;

import baseball.object.ThreeNumber;
import baseball.service.*;

public class GameController {

    public void startGame(){
        beforeGame();
        playGame();
        afterGame();
    }

    private void beforeGame() {

    }

    private void playGame(){
        PickNumberService pickNumber = PickNumberServiceImpl.getInstance();
        ThreeNumber computerNumber = pickNumber.pickNumber();

        UserInputNumberService userInputNumber = UserInputNumberServiceImpl.getInstance();
        ThreeNumber userNumber = userInputNumber.userInputNumber();

        CompareNumberService compareNumberService = CompareNumberServiceImpl.getInstance();
        while (!compareNumberService.compareNumber(computerNumber, userNumber)) {
            userNumber = userInputNumber.userInputNumber();
        }
        printEnd();
    }

    private void afterGame(){

    }

    private void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
}
