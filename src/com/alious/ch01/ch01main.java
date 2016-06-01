package com.alious.ch01;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by aliouswang on 16/6/1.
 */
public class ch01main {

    public static void main(String [] args) {
//        Bag<Integer> bag = new Bag<>();
//        bag.add(0);
//        bag.add(3);
//        bag.add(2);
//        bag.add(9);
//
//        Iterator<Integer> iterator = bag.iterator();
//        int index = 0;
//        while (iterator.hasNext()) {
////            Integer next = iterator.next();
//            if (index ++ == 0) {
//                iterator.remove();
//            }
//            else System.out.println(iterator.next());
//        }
//        System.out.println("#####");
//        for (Integer integer : bag) {
//            System.out.println(integer);
//        }

        Stack<Integer> numberStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        String orginal = "(1+((2+3)*(4*5)))";
        for (char ch : orginal.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                numberStack.push(Integer.parseInt(ch + ""));
            }else if (ch == '+' || ch == '-'
                    || ch == '*' || ch == '/') {
                operatorStack.push(ch);
            }else if (ch == ')') {
                char operator = operatorStack.pop();
                int num2 = numberStack.pop();
                int num1 = numberStack.pop();
                int result = 0;
                if (operator == '+') {
                    result = num1 + num2;
                }else if (operator == '-') {
                    result = num1 - num2;
                }else if (operator == '*') {
                    result = num1 * num2;
                }else if (operator == '/') {
                    result = num1 / num2;
                }
                numberStack.push(result);
            }
        }

        int result = numberStack.pop();
        System.out.println(result + "");
    }

}
