package com.imc.integration;

import com.imc.artificialIntelligence.AI;
import com.imc.configuration.AppConfig;
import com.imc.controller.App;
import com.imc.controller.GameLogic;
import com.imc.controller.InputController;
import com.imc.controller.OutputController;
import com.imc.model.Movement;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AppIntegrationTest {

    @Autowired
    OutputController outputController;

    @Autowired
    GameLogic gameLogic;

    @Autowired
    AI ai;

    App app;

    InputController inputController;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Before
    public void initWithMocks(){
        inputController = mock(InputController.class);
        app = new App(inputController,gameLogic,ai,outputController);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void play() {
        int numberOfIterations = 1;
        when(inputController.readNumberOfIterations()).thenReturn(Optional.of(numberOfIterations));
        when(inputController.readUserMovement()).thenReturn(Optional.of(Movement.PAPER));
        app.play();

        verify(inputController, times(numberOfIterations)).readUserMovement();
        assertThat(outContent.toString().trim(), CoreMatchers.containsString("Winner is") );
    }


}