package cn.alycat.leetcode.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class Solution {
    public static void main(String[] args) {
        String test = "dvdf";
        System.out.println(new Solution().lengthOfLongestSubstring(test));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);//存储字符及对应位置，若之前存储过该字符，则用新位置替换旧位置
            max = Math.max(max, i - j + 1);//当最大长度发生变化时，及时更新
        }
        return max;
    }
}
