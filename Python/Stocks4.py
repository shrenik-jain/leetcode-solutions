'''
Question : You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
           Design an algorithm to find the maximum profit. You may complete at most k transactions.
           Notice that you may not engage in multiple transactions simultaneously (i.e. you must sell the stock before you buy again).

Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
'''

class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n = len(prices)
        
        if not k or not prices:
            return 0
        
        if k>=n//2:
            return self.Transaction(prices)
        
        dp = [[0 for _ in range(n)] for _ in range(k+1)]
        
        for i in range(1 , k+1):
            total = prices[0]
            
            for j in range(1,n):
                dp[i][j] = max(dp[i][j-1], prices[j] - total)
                total = min(total, prices[j]-dp[i-1][j-1])
                
        return dp[-1][-1]
    
    def Transaction(self, prices):
        amount = 0
            
        for i in range(1,len(prices)):
            amount += max(0, prices[i]- prices[i-1])
            
        return amount
        
