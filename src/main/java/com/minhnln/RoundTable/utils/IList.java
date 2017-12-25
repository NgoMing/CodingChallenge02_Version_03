package com.minhnln.RoundTable.utils;

public interface IList {
    int size();
    boolean isEmpty();

    // access methods
    int getFirst();
    int getLast();

    // update methods
    void addFirst(int e);
    void addLast(int e);

    int removeFirst();

    // test-supporting methods
    int[] toArray();
}
