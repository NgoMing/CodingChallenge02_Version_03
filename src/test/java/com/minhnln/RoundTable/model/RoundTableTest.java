package com.minhnln.RoundTable.model;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import static com.googlecode.catchexception.CatchException.*;

@RunWith(JUnitParamsRunner.class)
public class RoundTableTest {
    private RoundTable roundTable = new RoundTable();

    /* Create test cases for Init testing
     * Including: number of children
     *            number of children skipped
     *            array of children
     */
    private static final Object[] getInitTestCases() {
        return new Object[] {
                new Object[] {5, 1, new int[]{1, 2, 3, 4, 5}},
                new Object[] {7, 20, new int[]{1, 2, 3, 4, 5, 6, 7}}
        };
    }

    @Test
    @Parameters(method = "getInitTestCases")
    public void initNormalCases(int numberOfChildren, int numberToSkip,
                                int[] arrayOfChildren) throws Exception {
        roundTable.init(numberOfChildren, numberToSkip);

        assertEquals(numberToSkip, roundTable.getNumberToSkip());
        assertArrayEquals(arrayOfChildren, roundTable.getTable().toArray());
    }

    /* Create invalid test cases for Init testing
     * Including: number of children
     *            number of children skipped
     */
    private static final Object[] getInvalidInitTestCases() {
        return new Object[] {
                new Object[] {0, 2},
                new Object[] {-10, 20},
                new Object[] {10, 0},
                new Object[] {10, -20}
        };
    }

    @Test (expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidInitTestCases")
    public void invalidInitCase(int numberOfChildren, int numberToSkip) {
        roundTable.init(numberOfChildren, numberToSkip);
    }

    /* Create invalid test cases for Remove Child testing
     * Including: number of children
     *            number of children skipped
     *            id of child out
     *            array of children remaining
     */
    private static final Object[] getRemoveChildTestCases() {
        return new Object[] {
                new Object[] {5, 2, 2, new int[]{3, 4, 5, 1}},
                new Object[] {3, 4, 1, new int[]{2, 3}},
                new Object[] {4, 4, 4, new int[]{1, 2, 3}},
        };
    }

    @Test
    @Parameters(method = "getRemoveChildTestCases")
    public void removeChild(int numberOfChildren, int numberToSkip, int idChildOutExpected,
                            int[] arrayChildrenRemaning) throws Exception {
        roundTable.init(numberOfChildren, numberToSkip);
        int idChildOut = roundTable.removeChild();

        assertEquals(idChildOutExpected, idChildOut);
        assertArrayEquals(arrayChildrenRemaning, roundTable.getTable().toArray());
    }

    /* Create test cases for hasOneChild testing
     * Including: number of children
     *            number of children skipped
     */
    private static final Object[] getHasOneChildTestCases() {
        return new Object[] {
                new Object[] {5, 1},
                new Object[] {7, 20}
        };
    }

    @Test
    @Parameters(method = "getHasOneChildTestCases")
    public void hasOneChild(int numberOfChildren, int numberToSkip) throws Exception {
        roundTable.init(numberOfChildren, numberToSkip);
        assertFalse(roundTable.hasOneChild());

        for (int i = 0; i < numberOfChildren - 1; i++)
            roundTable.removeChild();

        assertTrue(roundTable.hasOneChild());
    }
}