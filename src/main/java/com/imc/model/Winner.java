package com.imc.model;

public enum Winner {
    COMPUTER,
    TIE,
    USER;

    @Override
    public String toString(){
        switch (this) {
            case COMPUTER: return "computer";
            case TIE: return "tie";
            case USER: return "user";
            default: throw new IllegalArgumentException();
        }
    }
}
