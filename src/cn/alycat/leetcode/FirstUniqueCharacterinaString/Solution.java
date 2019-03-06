package cn.alycat.leetcode.FirstUniqueCharacterinaString;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 *
 * */
public class Solution {
    public int firstUniqChar2(String s) {
        if(s == null || s.length() < 1)return -1;
        if(s.length() == 1 ) return 0;
        String cp = new String(s);
        int idx =0;
        while(idx < s.length()){
            String temp = s.charAt(idx)+"";
            int location= s.lastIndexOf(temp);
            if(location!=idx){
                s = s.replaceAll(temp,"");
            }else{
                return cp.indexOf(temp);
            }

        }
        return -1;
    }

    public int firstUniqChar(String s) {
        if(s == null || s.length() < 1)return -1;
        if(s.length() == 1 ) return 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char temp = s.charAt(i);
            if(!map.containsKey(temp)){
                map.put(temp,i);
            }else {
                map.put(temp,i+s.length());
            }
        }
        int a = 'a';
        System.out.println(map.keySet());
        System.out.println(map.values());
        int idx = s.length();
        for(int i = a; i<a+26;i++){
            if(map.containsKey((char)i) && map.get((char)i) <= idx){
                idx =  map.get((char)i);
            }
        }
        return idx ==s.length()?-1:idx;
    }

    public static void main(String[] args) {
        String s = "cc";
        System.out.println(new Solution().firstUniqChar(s));
    }
}
