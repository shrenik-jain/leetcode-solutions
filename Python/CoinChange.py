'''
Question : You are given coins of different denominations and a total amount of money amount. 
           Write a function to compute the fewest number of coins that you need to make up that amount. 
           If that amount of money cannot be made up by any combination of the coins, return -1.

Link : https://leetcode.com/problems/coin-change/
'''

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = [maxsize for i in range(amount+1)]
        memo[0] = 0
        
        if amount == 0:
            return 0
        
        for i in range(1 , amount+1):
            
            for coin in coins:
                
                if i >= coin:
                    memo[i] = min(memo[i] , memo[i-coin]+1)
                    
        if memo[amount] > amount:
            return -1
        
        return memo[-1]
                    
