package com.alious.ch02;

/**
 * Created by aliouswang on 16/6/1.
 */
public class SortUtil {

    /**
     * 选择排序
     * @param array
     */
    public static void selectSort(Comparable [] array) {
        int len = array.length;
        for (int i =0 ;i < len - 1; i ++) {
            Comparable smallest = array[i];
            int index = i;
            for (int j = i +1 ;j < len ; j ++) {
                if (less(array[j], smallest)) {
                    smallest = array[j];
                    index = j;
                }
            }
            exch(array, i, index);
        }
    }

    public static void insertSort(Comparable [] array) {
        int len = array.length;
        for (int i = 1;i <len; i ++) {
            Comparable tag = array[i];
            int index = i;
            for (int j = i; j > 0; j --) {
                if (less(array[j], array[j - 1])) {
                    exch(array, j, j -1);
                }
            }
        }
    }



    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable [] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void show(Comparable [] array) {
        for (int i = 0;i < array.length; i ++) {
            System.out.print(array[i] + ",");
        }
    }

    public static boolean isSorted(Comparable [] array) {
        for (int i = 0;i < array.length - 1; i ++) {
            if (less(array[i + 1], array[i])) {
                return false;
            }
        }
        return true;
    }

}