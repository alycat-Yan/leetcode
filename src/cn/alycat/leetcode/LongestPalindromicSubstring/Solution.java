package cn.alycat.leetcode.LongestPalindromicSubstring;
/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * */
public class Solution {

    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1 )return null;
        if(s.length() == 1) return s;
        return  null;
    }
}
