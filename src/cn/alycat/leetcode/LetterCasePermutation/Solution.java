package cn.alycat.leetcode.LetterCasePermutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int minimumCostIncurred(int numTotalEdgeNodes,
                            int numTotalAvailableNetworkRoutes,
                            List<List<Integer>> networkRoutesAvailable,
                            int numNewNetworkRoutesConstruct,
                            List<List<Integer>> costNewNetworkRoutesConstruct)
    {
        // WRITE YOUR CODE HERE
        if(numTotalEdgeNodes == 0 && numNewNetworkRoutesConstruct == 0 ){return -1;}
        Map<Integer,Integer> map = new HashMap<>();
        for(List<Integer> route:networkRoutesAvailable){
            if(!map.containsKey(route.get(0))){
                map.put(route.get(0),route.get(1));
            }else if(!map.containsKey(route.get(1))){
                map.put(route.get(1),route.get(0));
            }
        }
        int path = 0;
        for(List<Integer> route:costNewNetworkRoutesConstruct){
            if(!map.containsKey(route.get(0)) && !map.containsValue(route.get(0))){
                path +=route.get(2);
            }else if(map.containsKey(route.get(0)) && !map.containsValue(route.get(1))){
                path +=route.get(2);
            }
        }
        return path;
    }
    public static void main(String[] args) {
       List<List<Integer>> networkRoutesAvailable =new ArrayList<>();

        List<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(2);
        List<Integer> a2 = new ArrayList<>();
        a2.add(3);
        a2.add(4);
        List<Integer> a3 = new ArrayList<>();
        a3.add(4);
        a3.add(5);
        List<Integer> a4 = new ArrayList<>();
        a4.add(3);
        a4.add(5);
        List<List<Integer>> costNewNetworkRoutesConstruct = new ArrayList<>();

    }
}
