package com.imc.model;

public enum Movement {
    ROCK,
    SCISSORS,
    PAPER;

    @Override
    public String toString(){
        switch (this) {
            case ROCK: return "rock";
            case SCISSORS: return "scissors";
            case PAPER: return "paper";
        }
        throw new IllegalArgumentException("Movement not supported");
    }

}
