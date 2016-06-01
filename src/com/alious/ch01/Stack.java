package com.alious.ch01;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by aliouswang on 16/6/1.
 */
public class Stack<E> implements Iterable<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object [] elementData;

    private int size;

    public Stack() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public void push(E e) {
        if (size < elementData.length - 1) {
            elementData[size] = e;
        }else {
            elementData = Arrays.copyOf(elementData, elementData.length << 1);
            elementData[size] = e;
        }
        size ++;
    }

    public E pop() {
        E result = (E)elementData[size - 1];
        size --;
        return result;
    }

    private class Iter implements Iterator<E> {

        int cursor;

        public Iter() {
            cursor = size - 1;
        }

        @Override
        public boolean hasNext() {
            return cursor >= 0;
        }

        @Override
        public E next() {
            return (E)elementData[cursor --];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }
}
