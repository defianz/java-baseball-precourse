package baseball.controller;

import baseball.service.PickNumberService;
import baseball.service.PickNumberServiceImpl;

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

    }

    private void afterGame(){

    }
}
