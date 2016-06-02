package com.alious.util;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by aliouswang on 16/6/2.
 */
public class Utils {

    public static Integer [] randomIntArray(int... size) {
        int initSize = 50;
        if (size != null && size.length > 0) {
            initSize = size[0];
        }
        Integer [] result = new Integer[initSize];
        Random random = new Random(System.currentTimeMillis());
        int i = 0;
        while (initSize-- > 0) {
            result[i ++] = random.nextInt(1000);
        }
        return result;
    }

    public static Integer [] randomSortedIntArray(int... size) {
        Integer [] result = randomIntArray(size);
        Arrays.sort(result);
        return result;
    }

}
