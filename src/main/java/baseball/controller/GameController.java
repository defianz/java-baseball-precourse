package baseball.controller;

import baseball.object.ThreeNumber;
import baseball.service.PickNumberService;
import baseball.service.PickNumberServiceImpl;
import baseball.service.UserInputNumberService;
import baseball.service.UserInputNumberServiceImpl;

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
    }

    private void afterGame(){

    }
}
