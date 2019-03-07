package cn.alycat.leetcode.BestTimetoBuyandSellStock;



/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * */

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length <2)return 0;
        int buy = 0;
        int sell = buy + 1;
        int price = 0;
        while(sell<prices.length){
            if(prices[sell] < prices[buy]){
                buy = sell;
            }
            int temp = prices[sell] - prices[buy];
            if(price <temp ){
                price = temp;
            }
            sell++;
        }
        return price ;
    }

    public static void main(String[] args) {
//        int[] prices = {2,4,1};
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {7,6,4,3,1};
        System.out.println(new Solution().maxProfit(prices));
    }
}
