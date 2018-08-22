package com.imc.configuration;

import com.imc.artificialIntelligence.AI;
import com.imc.artificialIntelligence.HistoryBasedStrategy;
import com.imc.artificialIntelligence.Strategy;
import com.imc.controller.App;
import com.imc.controller.GameLogic;
import com.imc.controller.InputController;
import com.imc.controller.OutputController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public App app(InputController inputController,
                   GameLogic gameLogic,
                   AI ai,
                   OutputController outputController) {
        return new App(inputController, gameLogic, ai, outputController);
    }

    @Bean
    public GameLogic gameLogic(OutputController outputController) {
        return new GameLogic(outputController);
    }

    @Bean
    public InputController inputController(OutputController outputController) {
        return new InputController(outputController);
    }

    @Bean public OutputController outputController(){
        return new OutputController();
    }


    @Bean
    public AI ai(Strategy strategy) {
        return new AI(strategy);
    }

    @Bean
    public Strategy strategy(){
        return new HistoryBasedStrategy();
    }


}