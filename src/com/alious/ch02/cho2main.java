package com.alious.ch02;

/**
 * Created by aliouswang on 16/6/1.
 */
public class cho2main {

    public static void main(String [] args) {
        Integer [] array = {3,1,0,9,6,2,8,10,7};
//        SortUtil.selectSort(array);
        SortUtil.insertSort(array);
        assert SortUtil.isSorted(array);
        SortUtil.show(array);
    }

}
