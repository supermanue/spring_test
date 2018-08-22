package com.imc.controller;

import com.imc.artificialIntelligence.AI;
import com.imc.model.Movement;
import com.imc.model.Winner;

import javax.swing.text.html.Option;
import java.util.Optional;

public class App {
    private InputController inputController;
    private GameLogic gameLogic;
    private AI ai;
    private OutputController outputController;

    public App(InputController inputController,
               GameLogic gameLogic,
               AI ai,
               OutputController outputController){

        this.inputController = inputController;
        this.gameLogic = gameLogic;
        this.ai = ai;
        this.outputController = outputController;
    }

    public void play() {
        Optional<Integer> numberOfIterations = Optional.empty();
        while (!numberOfIterations.isPresent()) {
            numberOfIterations = inputController.readNumberOfIterations();
        }

        for (int x = 0; x < numberOfIterations.get(); x++)
            this.playOne();
    }


    public void playOne(){
        Optional<Movement> maybeMovement = inputController.readUserMovement();
        while (!maybeMovement.isPresent()) {
            this.outputController.print("Could not read user input, please repeat.");
            maybeMovement = inputController.readUserMovement();
        }

        Movement userMovement = maybeMovement.get();
        Movement computerMovement = ai.getMovement();
        Winner winner = gameLogic.getWinner(userMovement, computerMovement);
        gameLogic.showStats(userMovement, computerMovement, winner);
        ai.storeResult(userMovement, winner);
    }

}
