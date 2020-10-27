/*
Question : Say you have an array for which the ith element is the price of a given stock on day i.
           Design an algorithm to find the maximum profit. You may complete at most two transactions.
           Note: You may not engage in multiple transactions at the same time (i.e. you must sell the stock before you buy again).

Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
*/

class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length == 0 || prices.length == 1) {
            return 0;
        }
        
        // Max From Left
        
        int leastsf = prices[0];
        int mpist = 0;
        int [] dpl = new int[prices.length];
        
        for(int i=1;i<prices.length;i++) {
            
            if(prices[i]<leastsf) {
                leastsf = prices[i];
            }
            
            mpist = prices[i]-leastsf;
            
            if(mpist > dpl[i-1]) {
                dpl[i] = mpist;
            }
            else {
                dpl[i] = dpl[i-1];
            }
        }
        
        // Max From Right

        int mpibt = 0;
        int maxat = prices[prices.length-1];
        int [] dpr = new int[prices.length];
        
        for(int i=prices.length-2;i>=0;i--) {
            
            if(prices[i]>maxat) {
                maxat = prices[i];
            }
            
            mpibt = maxat - prices[i];
            
            if(mpibt > dpr[i+1]) {
                dpr[i] = mpibt;
            }
            else {
                dpr[i] = dpr[i+1];
            }
        }
        
        // Overall Profit
        
        int op = 0;
        
        for(int i=0;i<prices.length;i++) {
            
            if(dpl[i] + dpr[i] > op) {
                op = dpl[i] + dpr[i];
            }
        }
        
        return op;   
    }
}
