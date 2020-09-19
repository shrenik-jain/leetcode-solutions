/*
Question : Say you have an array for which the ith element is the price of a given stock on day i.
           If you were only permitted to complete at most one transaction (i.e. buy one and sell one share of the stock), 
           design an algorithm to find the maximum profit. Note that you cannot sell a stock before you buy one.

Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/

class Solution {
    public int maxProfit(int[] prices) {
        
        int least = Integer.MAX_VALUE;
        int op = 0;
        int profit = 0;
        
        for(int i=0; i<prices.length; i++) {
            
            if(prices[i] < least) {
                least = prices[i];
            }
            
            profit = prices[i] - least;
            
            if(profit > op) {
                op = profit;
            }
        }
        
        return op;
    }
}
