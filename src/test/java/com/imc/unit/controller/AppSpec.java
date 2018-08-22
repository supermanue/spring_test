package com.imc.unit.controller;

import com.imc.artificialIntelligence.AI;
import com.imc.configuration.AppConfig;
import com.imc.controller.App;
import com.imc.controller.GameLogic;
import com.imc.controller.InputController;
import com.imc.controller.OutputController;
import com.imc.model.Movement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AppSpec {

    App app;

    @Autowired
    GameLogic gameLogic;

    @Autowired
    AI ai;

    @Autowired
    OutputController outputController;

    InputController inputController;

    @Before
    public void initWithMocks(){
        inputController = mock(InputController.class);
        app = new App(inputController,gameLogic,ai,outputController);
    }

    @Test
    public void play() {
        int numberOfIterations = 3;
        when(inputController.readNumberOfIterations()).thenReturn(Optional.of(numberOfIterations));
        when(inputController.readUserMovement()).thenReturn(Optional.of(Movement.PAPER));
        app.play();
        verify(inputController, times(numberOfIterations)).readUserMovement();
    }

    @Test
    public void playWithErrorOnNumberOfIterationsInput() {
        when(inputController.readNumberOfIterations()).thenReturn(Optional.empty(),Optional.of(1));
        when(inputController.readUserMovement()).thenReturn(Optional.of(Movement.PAPER));
        app.play();
        verify(inputController, times(2)).readNumberOfIterations();
    }

    @Test
    public void playOne() {
        when(inputController.readUserMovement()).thenReturn(Optional.of(Movement.PAPER));
        app.playOne();
        verify(inputController,times(1) ).readUserMovement();
    }

    @Test
    public void plaOneWithErrorOnAUserMovementInput() {
        when(inputController.readUserMovement()).thenReturn(Optional.empty(),Optional.of(Movement.PAPER));
        app.playOne();
        verify(inputController, times(2)).readUserMovement();
    }
}