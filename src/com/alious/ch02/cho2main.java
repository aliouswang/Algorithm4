package com.alious.ch02;

import com.alious.util.Utils;

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
        SortUtil.basicQuickSort(array);

        System.out.println(System.currentTimeMillis() - curTime);
//        assert SortUtil.isSorted(array);
//        SortUtil.show(array);
    }

}
