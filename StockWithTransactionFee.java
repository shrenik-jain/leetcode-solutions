/*
Question : Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; 
           and a non-negative integer fee representing a transaction fee.
           You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. 
           You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
           Return the maximum profit you can make.

Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
*/

class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        int obsp = -prices[0];
        int ossp = 0;
        
        for(int i=1; i<prices.length; i++) {
            int nbsp = 0;
            int nssp = 0;
            
            if(ossp - prices[i] > obsp) {
                nbsp = ossp - prices[i];
            } 
            else {
                nbsp = obsp;
            }
            
            if(obsp + prices[i] - fee > ossp) {
                nssp = obsp + prices[i] - fee;
            }
            else {
                nssp = ossp;
            }
            
            obsp = nbsp;
            ossp = nssp;
        }
        
        return ossp;
    }
}
