'''
Question : You are given coins of different denominations and a total amount of money. 
           Write a function to compute the number of combinations that make up that amount. 
           You may assume that you have infinite number of each kind of coin.

Link : https://leetcode.com/problems/coin-change-2/
'''

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        memo = [1 if i==0 else 0 for i in range(amount+1)]
        
        for i in range(len(coins)):
            for j in range(coins[i],len(memo)):
                memo[j] += memo[j-coins[i]]
                
        return memo[-1]
        
