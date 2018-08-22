package com.imc.artificialIntelligence;

import com.imc.model.Movement;
import com.imc.model.Winner;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class RandomStrategy implements Strategy {
    private Random randomGenerator;
    private List<Movement> movements;

    public RandomStrategy(){

        randomGenerator = new Random();
        movements = Arrays.asList(Movement.ROCK, Movement.PAPER, Movement.SCISSORS);
    }

    @Override
    public Movement getMovement() {
        return movements.get(randomGenerator.nextInt(3));
    }

    @Override
    public void storeResult(Movement userMovement, Winner winner) {}
}
