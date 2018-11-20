package com.cqupt.algorithm;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Stack;

/**
 * @description leetcode第九题
 *
 * @author hetiantian
 * @date 2018/11/20 下午1:24
 * @version 1.0
 */
public class Solution9 {
    public static boolean isPalindrome(int x) {
        String input = String.valueOf(x);
        Stack<Character> inputStack = new Stack<>();
        Stack<Character> outputStack = new Stack<>();
        char[] inputChar = input.toCharArray();
        int length = inputChar.length;
        for (int i = 0; i < length; i++) {
            inputStack.push(inputChar[i]);
            outputStack.push(inputChar[length - i - 1]);
        }

        return outputStack.equals(inputStack) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
