package com.imc.unit.controller;

import com.imc.configuration.AppConfig;
import com.imc.controller.InputController;
import com.imc.model.Movement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class InputControllerSpec {

    @Autowired
    InputController inputController;

    @Test
    public void parseNumberOfIterations() {
        assertEquals(inputController.parseNumberOfIterations("1"), Optional.of(1));
        assertEquals(inputController.parseNumberOfIterations("-1"), Optional.empty());
        assertEquals(inputController.parseNumberOfIterations("house"), Optional.empty());
        assertEquals(inputController.parseNumberOfIterations("1 2"), Optional.empty());
        assertEquals(inputController.parseNumberOfIterations("99999999999"), Optional.empty());
    }

    @Test
    public void parseUserMovement() {
        assertEquals(inputController.parseUserMovement("R"), Optional.of(Movement.ROCK));
        assertEquals(inputController.parseUserMovement("r"), Optional.of(Movement.ROCK));
        assertEquals(inputController.parseUserMovement("Rock"), Optional.of(Movement.ROCK));
        assertEquals(inputController.parseUserMovement("P"), Optional.of(Movement.PAPER));
        assertEquals(inputController.parseUserMovement("p"), Optional.of(Movement.PAPER));
        assertEquals(inputController.parseUserMovement("Paper"), Optional.of(Movement.PAPER));
        assertEquals(inputController.parseUserMovement("S"), Optional.of(Movement.SCISSORS));
        assertEquals(inputController.parseUserMovement("s"), Optional.of(Movement.SCISSORS));
        assertEquals(inputController.parseUserMovement("scissors"), Optional.of(Movement.SCISSORS));
        assertEquals(inputController.parseUserMovement(""), Optional.empty());
        assertEquals(inputController.parseUserMovement("other"), Optional.empty());
    }
}