package com.minhnln.RoundTable.simulator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.googlecode.catchexception.CatchException.*;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class RoundTableGameTest {
    /* Create test cases for end-end testing
     * Including: number of children
     *            number of children skipped
     *            list of children which is out
     *            the id of the winner
     */
    private static final Object[] getTestCases() {
        return new Object[] {
                new Object[] {5, 1, new int[]{1, 2, 3, 4}, 5},
                new Object[] {7, 3, new int[]{3, 6, 2, 7, 5, 1}, 4},
                new Object[] {4, 11, new int[]{3, 1, 2}, 4},
                new Object[] {14, 4, new int[]{4, 8, 12, 2, 7, 13, 5, 11, 6, 1, 14, 3, 10}, 9},
                new Object[] {8, 3, new int[]{3, 6, 1, 5, 2, 8, 4}, 7}
        };
    }

    /* Create test cases for end-end testing of performance
     * Including: number of children
     *            number of children skipped
     *            the if of the winner
     */
    private static final Object[] getTestCasesForPerformace() {
        return new Object[] {
                new Object[] {500000, 10, 20687},
                new Object[] {1000000, 123, 137456}
        };
    }

    private RoundTableGame roundTableGame = new RoundTableGame();

    @Test
    @Parameters(method = "getTestCases")
    public void playNormalCasesCorrectly(int numOfChildren, int numToSkip,
                              int[] childrenOutList, int winnerID) {
        roundTableGame.create(numOfChildren, numToSkip);
        roundTableGame.play();

        assertArrayEquals(childrenOutList, roundTableGame.getListOfChildrenOut().toArray());
        assertEquals(winnerID, roundTableGame.getWinner());
    }

    @Test
    @Parameters(method = "getTestCasesForPerformace")
    public void playPerformanceCasesCorrectly(int numOfChildren, int numToSkip, int winnerID) {
        roundTableGame.create(numOfChildren, numToSkip);
        roundTableGame.play();

        assertEquals(winnerID, roundTableGame.getWinner());
    }
}