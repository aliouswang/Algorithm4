package com.alious.ch03;

/**
 * Created by aliouswang on 16/6/7.
 */
public class Main {

    public static void main(String [] args) {

        BST<Integer, Integer> bst = new BST<>();
        bst.put(3,3);
        bst.put(2,2);
        bst.put(5,5);
        bst.put(1,1);
        bst.put(4,4);
        bst.put(9,9);
        bst.put(8, 8);
        bst.put(10,10);
        bst.put(7,7);

        bst.delete(8);
        bst.delete(3);
//        bst.delete(5);

//        System.out.println(bst.toString());
        bst.printRoot();
    }


}
