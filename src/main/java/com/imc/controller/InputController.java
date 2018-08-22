package com.imc.controller;

import com.imc.model.Movement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;

public class InputController {

    private OutputController outputController;
    BufferedReader buffer;

    public InputController(OutputController outputController){
        this.outputController = outputController;
        this.buffer =new BufferedReader(new InputStreamReader(System.in));
    }

    public Optional<Integer> readNumberOfIterations(){
        outputController.print("number of games?");
        String line;
        try {
            line = buffer.readLine();
        } catch (Exception e) {return Optional.empty();}
        return this.parseNumberOfIterations(line.trim());
    }

    public Optional<Integer> parseNumberOfIterations(String line){
        int numberOfGames;

        try {
            numberOfGames =Integer.parseInt(line);
        } catch (Exception e) {return Optional.empty();}

        if (numberOfGames > 0)
            return Optional.of(numberOfGames);
        else
            return Optional.empty();
    }

    public Optional<Movement> readUserMovement() {
        outputController.print("Paper, Rock, Scissors?");
        String line;

        try {
            line = buffer.readLine();
        } catch (Exception e) {return Optional.empty();}

        return this.parseUserMovement(line);
    }

    public Optional<Movement> parseUserMovement(String line){
        char input;
        try {
            input =Character.toLowerCase(line.charAt(0));
        } catch (Exception e) {return Optional.empty();}

        switch(input) {
            case 'r': return Optional.of(Movement.ROCK);
            case 'p': return Optional.of(Movement.PAPER);
            case 's': return Optional.of(Movement.SCISSORS);
            default: return Optional.empty();
        }
    }
}
