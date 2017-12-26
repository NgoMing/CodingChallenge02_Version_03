package com.minhnln.RoundTable.model;

import com.minhnln.RoundTable.utils.CircularlyList;

public class RoundTable {

    private int numberToSkip;
    private CircularlyList table;

    public void init(int numberOfChildren, int numberToSkip) {
        if (numberOfChildren <= 0)
            throw new IllegalArgumentException("The number of children (" +
                    numberOfChildren + ") should be positive!");

        if (numberToSkip <= 0)
            throw new IllegalArgumentException("The number to skip (" +
                    numberToSkip + ") should be positive!");

        table = new CircularlyList();

        for (int i = 0; i < numberOfChildren; i ++)
            table.addLast(i + 1);

        this.numberToSkip = numberToSkip;
    }

    // access methods for testing
    protected int getNumberToSkip() { return numberToSkip; }
    protected CircularlyList getTable() { return table; }

    public int removeChild() {
        table.rotate(numberToSkip - 1);
        return table.removeFirst();
    }

    public boolean hasOneChild() {
        return (table.size() == 1);
    }

    public int getCurrentChild() {
        return table.getFirst();
    }
}
