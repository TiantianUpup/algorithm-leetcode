package com.cqupt.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description leetcode第13题
 *
 * @author hetiantian
 * @date 2018/11/20 下午2:11
 * @version 1.0
 */
public class Solution13 {
    /**
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * */
    public static int romanToInt(String s) {
        //计算的值
        int sum = 0;
        //存储罗马数字的值
        Map<Character, Integer> romanNumber = getRomanMap();
        Stack<Character> inputStack = new Stack<>();

        //用于处理特殊的罗马计算使用
        //Stack<Character> specialStack = new Stack<>();
        char[] input = s.toCharArray();
        int length = input.length;
        for (int i = 0; i < length; i++) {
            inputStack.push(input[length - i -1]);
        }


        while (inputStack.size() > 0) {
            Character temp = inputStack.pop();
            if (temp != 'I' && temp != 'X' && temp != 'C') {
                sum += romanNumber.get(temp);
            } else {
                if (inputStack.size() > 0) {
                    //I的情况下
                    if (temp.equals('I')) {
                        if (inputStack.peek().equals('V') || inputStack.peek().equals('X')) {
                            sum += romanNumber.get(inputStack.peek());
                            sum -= romanNumber.get(temp);
                            //移除
                            inputStack.pop();
                        } else {
                            sum += romanNumber.get(temp);
                        }
                    }

                    //X的情况下
                    if (temp.equals('X')) {
                        if (inputStack.peek().equals('L') || inputStack.peek().equals('C')) {
                            sum += romanNumber.get(inputStack.peek());
                            sum -= romanNumber.get(temp);
                            //移除
                            inputStack.pop();
                        } else {
                            sum += romanNumber.get(temp);
                        }
                    }

                    //C的情况下
                    if (temp.equals('C')) {
                        if (inputStack.peek().equals('D') || inputStack.peek().equals('M')) {
                            sum += romanNumber.get(inputStack.peek());
                            sum -= romanNumber.get(temp);
                            //移除
                            inputStack.pop();
                        } else {
                            sum += romanNumber.get(temp);
                        }
                    }
                } else {
                    sum += romanNumber.get(temp);
                }
            }
        }
        return sum;
    }


    public static Map<Character, Integer> getRomanMap() {
        Map<Character, Integer> romanNumber = new HashMap<>(8);
        romanNumber.put('I', 1);
        romanNumber.put('V', 5);
        romanNumber.put('X', 10);
        romanNumber.put('L', 50);
        romanNumber.put('C', 100);
        romanNumber.put('D', 500);
        romanNumber.put('M', 1000);

        return romanNumber;
    }

    /**
     * DCXXI
     * */
    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("DCXXI"));
    }
}
