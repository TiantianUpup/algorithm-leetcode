package com.cqupt.algorithm;

import java.util.*;

/**
 * @description leetcode第14题
 *
 * @author hetiantian
 * @date 2018/11/20 下午10:26
 * @version 1.0
 */
public class Solution14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Arrays.sort(strs);
        //最少比较的次数
        int min = strs[0].length();
        for (int i = 0; i < min; i++) {
            Set<String> temp = new HashSet<>();
            for (int j = 0; j < strs.length; j++) {
                temp.add(String.valueOf(strs[j].charAt(i)));
            }

            if (temp.size() !=  1) {
                break;
            } else {
               sb.append(temp.iterator().next());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        String[] str1 = {"aa", "aa"};
        System.out.println(longestCommonPrefix(str1));
    }
}
