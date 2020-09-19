/*
Question : Say you have an array prices for which the ith element is the price of a given stock on day i.
           Design an algorithm to find the maximum profit. 
           You may complete as many transactions as you like (i.e. buy one and sell one share of the stock multiple times).
           Note: You may not engage in multiple transactions at the same time (i.e. you must sell the stock before you buy again).

Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
*/

class Solution {
    public int maxProfit(int[] prices) {
        
        int buy = 0;
        int sell = 0;
        int profit = 0;
        
        for(int i =1; i<prices.length; i++) {
            
             if(prices[i] > prices[i-1]) {
                 sell++;
             }
            
            else {
                profit += prices[sell] - prices[buy];
                buy = sell = i;
            }
        }
        
        profit += prices[sell] - prices[buy];
        
        return profit;     
    }
}
