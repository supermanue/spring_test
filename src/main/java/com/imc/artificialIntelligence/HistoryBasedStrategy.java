package com.imc.artificialIntelligence;

import com.imc.model.Movement;
import com.imc.model.Winner;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class HistoryBasedStrategy implements Strategy {
    private Random randomGenerator;
    private Map<Movement, Double> movements;
    private double lastMovementWeight=0.3;

    public HistoryBasedStrategy(){
        randomGenerator = new Random();
        movements = new HashMap();
        movements.put(Movement.PAPER, 1.0);
        movements.put(Movement.ROCK, 1.0);
        movements.put(Movement.SCISSORS, 1.0);
    }

    @Override
    public Movement getMovement() {
        double totalWeight = movements.values().stream().mapToDouble(a->a).sum();
        double desiredWeight = totalWeight * Math.random();
        double currentWeight = 0;
        for (Movement key: movements.keySet()){
            currentWeight += movements.get(key);
            if (currentWeight >= desiredWeight)
                return this.getWinnerFor(key);
        }
        throw new IllegalStateException("Could not create movement");

    }

    @Override
    public void storeResult(Movement userMovement, Winner winner) {
        movements.forEach((k, v) -> movements.replace(k, v*(1-lastMovementWeight)));
        movements.replace(userMovement, movements.get(userMovement) + lastMovementWeight);
    }

    private Movement getWinnerFor(Movement movement){
        switch (movement){
            case PAPER: return Movement.SCISSORS;
            case ROCK: return Movement.PAPER;
            case SCISSORS: return  Movement.ROCK;
        }
        throw new IllegalArgumentException("Movement not supported");
    }
}
