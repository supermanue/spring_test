package com.imc.controller;

import com.imc.model.Movement;
import com.imc.model.Winner;

public class GameLogic {
    private OutputController outputController;

    public GameLogic(OutputController outputController){
        this.outputController = outputController;
    }

    public Winner getWinner(Movement userMovement, Movement computerMovement){
        if (wins(userMovement, computerMovement))
            return Winner.USER;
        else if (wins(computerMovement, userMovement))
            return Winner.COMPUTER;
        return Winner.TIE;
    }

    public void showStats(Movement userMovement, Movement computerMovement, Winner winner){
        outputController.print("User input: " + userMovement);
        outputController.print("Computer input: " + computerMovement);
        outputController.print("Winner is: " + winner);
    }

    public Boolean wins(Movement one, Movement other){
        switch (one){
            case ROCK: return (other==Movement.SCISSORS);
            case PAPER: return (other == Movement.ROCK);
            case SCISSORS: return (other == Movement.PAPER);
        }
        throw new IllegalArgumentException("Movement not supported");
    }
}
