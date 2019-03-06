package cn.alycat.leetcode.ValidParentheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 */
public class Solution {
    public static void main(String[] args) {
        String test = "()[][][][]{{{";
        System.out.println(new Solution().isValid(test));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            Character ct = s.charAt(idx);
            Character in = null;
            if (stack.isEmpty()) {
                stack.push(ct);
            } else {
                in = stack.pop();
                if (in != null && isSame(in, ct)) {
                    stack.push(in);
                    stack.push(ct);
                }
            }
            idx++;
        }
        return stack.isEmpty();
    }

    private boolean isSame(char c1, char c2) {
        String t = "{([])}";
        int idx = t.indexOf(c1);
        int idx2 = t.indexOf(c2);
        if (idx + idx2 == t.length() - 1) return false;
        return true;
    }

}
