package com.alious.ch01;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by aliouswang on 16/6/1.
 */
public class Bag<E> implements Iterable<E>{

    private static final int DEFAULT_CAPACITY = 8;

    private int size;
    private int cursor = 0;

    private Object[] elementData;

    public Bag() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public Bag(int initialCapacity) {
        elementData = new Object[initialCapacity];
    }

    public void add(E e) {
        if (size < elementData.length - 1) {
            elementData[size++] = e;
        }else {
            int newCapacity = elementData.length << 1;
            elementData = Arrays.copyOf(elementData, newCapacity);
            elementData[size++] = e;
        }
    }

    public int size() {
        return size;
    }

    private class Iter implements Iterator<E> {

        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public E next() {
            return (E)elementData[cursor ++ ];
        }

        @Override
        public void remove() {
            if (cursor < size) {
                for (int i = cursor ; i < size - 1; i ++) {
                    elementData[i] = elementData[i + 1];
                }
                size --;
            }
        }
    }

    public Iterator<E> iterator() {
        return new Iter();
    }
}
