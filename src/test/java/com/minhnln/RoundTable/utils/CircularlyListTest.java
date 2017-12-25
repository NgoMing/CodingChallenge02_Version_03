package com.minhnln.RoundTable.utils;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class CircularlyListTest {
    private static final Object[] getCircularlyList() {
        return new Object[] {
                new int[] {-1},
                new int[] {1, 2, 3}
        };
    }

    // create arrays which use to test rotate method
    // utilise the first element as numOfStep param
    private static final Object[] getRotateArray() {
        return new Object[] {
                new int[] {0, 1, 2, 3, 4},
                new int[] {1, 2, 3, 4, 0},
                new int[] {2, 3, 4, 0, 1},
                new int[] {3, 4, 0, 1, 2},
                new int[] {4, 0, 1, 2, 3}
        };
    }

    @Test
    @Parameters(method = "getCircularlyList")
    public void size(int[] array) throws Exception {
        CircularlyList list = new CircularlyList(array);

        assertEquals(array.length, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    public void isEmpty() throws Exception {
        CircularlyList emptyList = new CircularlyList();

        assertEquals(0, emptyList.size());
        assertTrue(emptyList.isEmpty());
    }

    @Test
    @Parameters(method = "getCircularlyList")
    public void getFirst(int[] array) throws Exception {
        CircularlyList list = new CircularlyList(array);

        assertEquals(array[0], list.getFirst());
    }

    @Test
    @Parameters(method = "getCircularlyList")
    public void getLast(int[] array) throws Exception {
        CircularlyList list = new CircularlyList(array);

        assertEquals(array[array.length - 1], list.getLast());
    }

    @Test
    @Parameters(method = "getCircularlyList")
    public void addFirst(int[] array) throws Exception {
        CircularlyList list = new CircularlyList(array);
        list.addFirst(-5);

        assertEquals(-5, list.getFirst());
    }

    @Test
    @Parameters(method = "getCircularlyList")
    public void addLast(int[] array) throws Exception {
        CircularlyList list = new CircularlyList(array);
        list.addLast(-5);

        assertEquals(-5, list.getLast());
    }

    @Test
    @Parameters(method = "getCircularlyList")
    public void removeFirst(int[] array) throws Exception {
        CircularlyList list = new CircularlyList(array);

        assertEquals(array[0], list.removeFirst());
    }

    @Test
    public void removeFirstEmptyList() {
        CircularlyList list = new CircularlyList();

        assertEquals(0, list.removeFirst());
    }

    @Test
    @Parameters(method = "getCircularlyList")
    public void toArray(int[] array) throws Exception {
        CircularlyList list = new CircularlyList(array);

        assertArrayEquals(array, list.toArray());
    }

    @Test
    public void toArrayEmptyList() {
        CircularlyList list = new CircularlyList();

        assertArrayEquals(null, list.toArray());
    }

    @Test
    @Parameters(method = "getRotateArray")
    public void rotate(int[] array) throws Exception {
        int[] initArray = {0, 1, 2, 3, 4};
        CircularlyList list = new CircularlyList(initArray);

        // utilise the first element of array as numOfStep param
        list.rotate(array[0] + array.length);
        assertArrayEquals(array, list.toArray());
    }

    @Test
    public void rotateEmptyList() {
        CircularlyList list = new CircularlyList();
        list.rotate(5);

        assertTrue(list.isEmpty());
    }

    @Test (expected = IllegalArgumentException.class)
    public void rotateNegativeParam() {
        CircularlyList list = new CircularlyList(new int[]{1, 2, 3});
        list.rotate(-2);
    }
}