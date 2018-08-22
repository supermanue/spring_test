package com.imc.unit.controller;

import com.imc.configuration.AppConfig;
import com.imc.controller.GameLogic;
import com.imc.model.Movement;
import com.imc.model.Winner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class GameLogicSpec {

    @Autowired
    GameLogic gameLogic;

    @Test
    public void getWinner() {
        assertEquals(gameLogic.getWinner(Movement.PAPER, Movement.PAPER), Winner.TIE);
        assertEquals(gameLogic.getWinner(Movement.PAPER, Movement.ROCK), Winner.USER);
        assertEquals(gameLogic.getWinner(Movement.PAPER, Movement.SCISSORS), Winner.COMPUTER);
        assertEquals(gameLogic.getWinner(Movement.ROCK, Movement.ROCK), Winner.TIE);
        assertEquals(gameLogic.getWinner(Movement.ROCK, Movement.SCISSORS), Winner.USER);
        assertEquals(gameLogic.getWinner(Movement.SCISSORS, Movement.SCISSORS), Winner.TIE);
    }

    @Test
    public void wins() {
        assertEquals(gameLogic.wins(Movement.PAPER, Movement.PAPER), false);
        assertEquals(gameLogic.wins(Movement.PAPER, Movement.ROCK), true);
        assertEquals(gameLogic.wins(Movement.PAPER, Movement.SCISSORS), false);
        assertEquals(gameLogic.wins(Movement.ROCK, Movement.ROCK), false);
        assertEquals(gameLogic.wins(Movement.ROCK, Movement.SCISSORS), true);
        assertEquals(gameLogic.wins(Movement.SCISSORS, Movement.SCISSORS), false);
    }
}