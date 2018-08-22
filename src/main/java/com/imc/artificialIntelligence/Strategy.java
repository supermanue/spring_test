package com.imc.artificialIntelligence;

import com.imc.model.Movement;
import com.imc.model.Winner;

public interface Strategy {
    Movement getMovement();
    void storeResult(Movement userMovement, Winner winner);
}
