package com.imc.unit.model;

import com.imc.model.Movement;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovementSpec {

    @Test
    public void toStringTest() {
        assertEquals(Movement.PAPER.toString(), "paper");
        assertEquals(Movement.ROCK.toString(), "rock");
        assertEquals(Movement.SCISSORS.toString(), "scissors");
    }
}