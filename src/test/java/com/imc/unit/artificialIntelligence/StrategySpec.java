package com.imc.unit.artificialIntelligence;

import com.imc.artificialIntelligence.Strategy;
import com.imc.configuration.AppConfig;
import com.imc.model.Movement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class StrategySpec {

    @Autowired
    Strategy strategy;

    @Test
    public void getMovement() {
        assertThat(strategy.getMovement(),instanceOf(Movement.class));
    }
}