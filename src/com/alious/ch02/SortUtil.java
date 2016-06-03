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

    /**
     * insert sort
     * @param array
     */
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

    /**
     * insert sort
     * @param array
     */
    public static void insertSort(Comparable [] array, int low, int high) {
        int len = high - low + 1;
        for (int i = 1;i <len; i ++) {
            for (int j = i; j > 0; j --) {
                if (less(array[j + low], array[j - 1 + low])) {
                    exch(array, j + low, j -1 + low);
                }
            }
        }
    }


    /**
     * Merge sort
     * @param array
     */
    public static void mergeSort(Comparable [] array) {
        int len = array.length;

        mergeSort(array, 0, len - 1);
    }

    private static void mergeSort(Comparable [] array, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;

        if (mid - low < 10) {
            insertSort(array, low, mid);
            insertSort(array, mid + 1, high);
            if (mid < high && less(array[mid], array[mid + 1])) {
                //has sorted, not need merge anymore
                return;
            }
            merge(array, low, mid, high);
            return;
        }

        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        if (mid < high && less(array[mid], array[mid + 1])) {
            //has sorted, not need merge anymore
            return;
        }
        merge(array, low, mid, high);
    }

    private static void merge(Comparable [] array, int low, int mid, int high) {
        int index1 = low;
        int index2 = mid + 1;
        Comparable [] tempArray = new Comparable[high - low + 1];
        int index = 0;
        while (index1 <= mid && index2 <= high) {
            if (less(array[index1], array[index2])) {
                tempArray[index ++] = array[index1 ++];
            }else {
                tempArray[index ++] = array[index2 ++];
            }
        }
        while (index1 <= mid) {
            tempArray[index ++] = array[index1 ++];
        }

        while (index2 <= high) {
            tempArray[index ++] = array[index2 ++];
        }
        for (int i = 0; i < high - low + 1; i ++) {
            array[i + low] = tempArray[i];
        }
    }

    /**
     * Basic quick sort
     *
     * @param array
     */
    public static void basicQuickSort(Comparable [] array) {
        int len = array.length;
        basicQuickSort(array, 0, len - 1);
    }

    private static void basicQuickSort(Comparable [] array, int low, int high) {
        if (high - low < 100) {
            insertSort(array, low, high);
            return;
        }
        int divider = partition(array, low, high);
        basicQuickSort(array, low, divider - 1);
        basicQuickSort(array, divider + 1, high);
    }

    private static int partition(Comparable [] array, int low, int high) {
        int left = low;
        int right = high;
        Comparable key = array[low];
        while (true) {
            while (less(array[left ++], key)) {
                if (left == high) break;
            }
            while (less(key, array[right --])) {
                if (right == low) break;
            }
            if (left >= right) break;
            exch(array, left, right);
        }
        exch(array, low, right);
        return right;
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
