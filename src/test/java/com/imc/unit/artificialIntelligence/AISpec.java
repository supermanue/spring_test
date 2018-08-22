package com.imc.unit.artificialIntelligence;

import com.imc.artificialIntelligence.AI;
import com.imc.artificialIntelligence.Strategy;
import com.imc.configuration.AppConfig;
import com.imc.model.Movement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AISpec {

    Strategy strategy;
    AI ai;

    @Before
    public void initWithMocks(){
        strategy = mock(Strategy.class);
        when(strategy.getMovement()).thenReturn(Movement.PAPER);
        ai = new AI(strategy);
    }

    @Test
    public void getMovement(){
        assertEquals(ai.getMovement(),Movement.PAPER);
    }

}