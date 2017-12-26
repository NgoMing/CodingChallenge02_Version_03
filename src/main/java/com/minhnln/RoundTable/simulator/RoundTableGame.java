package com.minhnln.RoundTable.simulator;

import com.minhnln.RoundTable.model.RoundTable;

public class RoundTableGame {
    private RoundTable roundTable;

    public void create(RoundTable roundTable, int numberOfChildren, int numberToSkip) {
        this.roundTable = roundTable;
        this.roundTable.init(numberOfChildren, numberToSkip);
    }
}
