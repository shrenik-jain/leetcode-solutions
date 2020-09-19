/*
Question : Say you have an array for which the ith element is the price of a given stock on day i.
           Design an algorithm to find the maximum profit. 
           You may complete as many transactions as you like with the following restrictions:
           1.You may not engage in multiple transactions at the same time (i.e. you must sell the stock before you buy again).
           2.After you sell your stock, you cannot buy stock on next day. (i.e. cooldown 1 day)

Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
*/

class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices.length == 0){
            return 0;
        }
        
        int obsp = - prices[0];
        int ossp = 0;
        int ocsp = 0;
        
        for(int i=1;i<prices.length;i++) {
            
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;
            
            if(ocsp - prices[i] > obsp) {
                nbsp = ocsp - prices[i];
            }
            
            else {
                nbsp = obsp;
            }
            
            if(obsp + prices[i] > ossp) {
                nssp = obsp + prices[i];
            }
            
            else {
                nssp = ossp;
            }
            
            if(ossp > ocsp) {
                ncsp = ossp;
            }
            else {
                ncsp = ocsp;
            }
            
            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;  
        }
        
        return ossp;  
    }
}
