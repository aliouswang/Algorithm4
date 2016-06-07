package com.alious.ch02;

import com.alious.util.Utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by aliouswang on 16/6/1.
 */
public class cho2main {

    public static void main(String [] args) {
        Integer [] array = Utils.randomSortedIntArray(5000);
        long curTime = System.currentTimeMillis();
//        SortUtil.selectSort(array);

//        SortUtil.insertSort(array, 0, array.length - 1);
//        SortUtil.mergeSort(array);
//        SortUtil.basicQuickSort(array);

        System.out.println(System.currentTimeMillis() - curTime);
//        assert SortUtil.isSorted(array);
//        SortUtil.show(array);

        MaxPQ<Integer> integerMaxPQ = new MaxPQ<>();
        integerMaxPQ.insert(5);
        integerMaxPQ.insert(3);
        integerMaxPQ.insert(8);
        integerMaxPQ.insert(15);
        integerMaxPQ.insert(13);
        integerMaxPQ.insert(18);
        integerMaxPQ.insert(25);
        integerMaxPQ.insert(23);
        integerMaxPQ.insert(28);
        integerMaxPQ.insert(35);
        integerMaxPQ.insert(33);
        integerMaxPQ.insert(38);

        System.out.println(integerMaxPQ.max());

//        Arrays.sort();

    }

}
