package cn.alycat.leetcode.ZigZagConversion;


import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * PINALSIGYAHRPI
 * PINASGYHPI
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * **/

public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() < 1 || numRows <1) return null;
        String str = "";
        int size = (numRows-1)*2;
        int idx = s.length()/size == 0?s.length()/size: s.length()/size+1;
        for (int i = 0; i <numRows ; i++) {

        }
        return null;
    }



    public String convert2(String s, int numRows) {
        int size = s.length();
        // 当行数小于等于1 或 大于原串的size时不用转换
        if (numRows <= 1 || numRows >= size) {
            return s;
        }

        // 字符串数组, 装的是行的对应的字符串
       String[] rowString = new String[numRows];
        int rowNum = 1;
        // 向下读还是向上读的标志
        int flag = 1;
        for (int i = 0; i < size; ++i) {
            if(rowString[rowNum - 1] ==null) rowString[rowNum - 1] ="";
            rowString[rowNum - 1] += s.charAt(i);
            if (rowNum == numRows) {
                flag = -1;
            }
            if (rowNum == 1) {
                flag = 1;
            }
            rowNum += flag;
        }
        String result ="";
        for (int i = 0; i < numRows; ++i) {
            result += rowString[i];
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String s2 = "PINALSIGYAHRPI";
        String s3 ="PINALSIGYAHRPI";
//        System.out.println(s.charAt(11111));
        System.out.println(new Solution().convert2(s,4));
    }
}
