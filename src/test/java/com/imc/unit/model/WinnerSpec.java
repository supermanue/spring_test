package com.imc.unit.model;

import com.imc.model.Winner;
import org.junit.Test;
import sun.jvm.hotspot.debugger.windbg.ia64.WindbgIA64ThreadFactory;

import static org.junit.Assert.*;

public class WinnerSpec {

    @Test
    public void toStringTest() {
        assertEquals(Winner.COMPUTER.toString(), "computer");
        assertEquals(Winner.USER.toString(), "user");
        assertEquals(Winner.TIE.toString(), "tie");
    }
}