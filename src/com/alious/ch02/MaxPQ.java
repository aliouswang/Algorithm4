package com.alious.ch02;

/**
 * Created by aliouswang on 16/6/3.
 */
public class MaxPQ<E extends Comparable<E>> {

    public static final int DEFAULT_MAX = 100;

    private E [] array;

    private int cursor;

    public MaxPQ() {
        array = (E[]) new Comparable[DEFAULT_MAX];
    }

    public MaxPQ(int max) {
        array = (E[]) new Comparable[max];
    }

    public MaxPQ(E [] a) {
        this.array = a;
    }

    public void insert(E e) {
        array[++cursor] = e;
        swip(cursor);
    }

    private void swip(int index) {
        while (index > 1) {
            if (array[index].compareTo(array[index/2]) > 0) {
                E temp = array[index];
                array[index] = array[index/2];
                array[index/2] = temp;
                index = index/2;
            }else break;
        }
    }

    private void sink(int index) {

    }

    public E max() {
        if (isEmpty()) return null;
        else return array[1];
    }

    public E deleteMax() {
        return null;
    }

    public boolean isEmpty() {
        return cursor <= 0;
    }

    public int size() {
        return cursor;
    }

}
