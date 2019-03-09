package cn.alycat.leetcode.LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public List<String> letterCasePermutation(String S) {
        if (S == null || S.length() < 1) return null;
        List<String> result = new ArrayList<>();
        add(S.toLowerCase().toCharArray(), 0, result);
        return result;
    }

    private void add(char[] a, int idx, List<String> list) {
        if (idx == a.length) {
            list.add(new String(a));
            return;
        }
        add(a, idx + 1, list);
        int le = (int) a[idx];
        if (le > 96 && le < 123) {
            a[idx] = (char)(le-32);
        }
        add(a, idx + 1, list);
        if (le > 64 && le < 91) {
            a[idx] = (char)(le+32);
        }
    }
}
