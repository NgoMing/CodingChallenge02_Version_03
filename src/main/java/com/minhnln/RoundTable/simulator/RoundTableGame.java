package com.minhnln.RoundTable.simulator;

import com.minhnln.RoundTable.model.RoundTable;
import com.minhnln.RoundTable.utils.CircularlyList;

import java.util.Collection;

public class RoundTableGame {
    private RoundTable roundTable = new RoundTable();
    private CircularlyList listOfChildrenOut = new CircularlyList();
    private int winner;

    public void create(int numberOfChildren, int numberToSkip) {
        roundTable.init(numberOfChildren, numberToSkip);
    }

    public void play() {
        while(!roundTable.hasOneChild()) {
            listOfChildrenOut.addLast(roundTable.removeChild());
        }

        winner = roundTable.getCurrentChild();
    }

    public CircularlyList getListOfChildrenOut() {
        return listOfChildrenOut;
    }

    public int getWinner() {
        return winner;
    }
}
