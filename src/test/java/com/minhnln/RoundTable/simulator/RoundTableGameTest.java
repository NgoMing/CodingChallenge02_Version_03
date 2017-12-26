package com.minhnln.RoundTable.simulator;

import com.minhnln.RoundTable.model.RoundTable;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RoundTableGameTest {
    final static int VALID_NUMBER_OF_CHILDREN = 12;
    final static int VALID_NUMBER_TO_SKIP = 5;

    @Test
    public void createPlayingTableCorrectly() {
        RoundTableGame roundTableGame = new RoundTableGame();
        RoundTable roundTable = mock(RoundTable.class);
        roundTableGame.create(roundTable, VALID_NUMBER_OF_CHILDREN, VALID_NUMBER_TO_SKIP);

        verify(roundTable).init(VALID_NUMBER_OF_CHILDREN, VALID_NUMBER_TO_SKIP);
    }
}