package baseball.controller;

import baseball.object.ThreeNumber;
import baseball.service.*;

public class GameController {

    public static boolean againGame;

    public GameController() {
        againGame = true;
    }

    public void startGame(){
        while (againGame) {
            beforeGame();
            playGame();
            afterGame();
        }
    }

    private void beforeGame() {
        againGame = false;
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
        AfterGameService afterGameService = AfterGameServiceImpl.getInstance();
        againGame = afterGameService.afterGame();
    }

    private void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
}
