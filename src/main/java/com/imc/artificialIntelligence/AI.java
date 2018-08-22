package com.imc.artificialIntelligence;

import com.imc.model.Movement;
import com.imc.model.Winner;

public class AI {
    private Strategy strategy;

    public AI(Strategy strategy){
        this.strategy= strategy;
    }

    public Movement getMovement() {
        return strategy.getMovement();
    }

    public void storeResult(Movement userMovement, Winner winner){
        strategy.storeResult(userMovement,winner);
    }
}
