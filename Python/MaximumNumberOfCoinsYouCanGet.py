'''
Question : There are 3n piles of coins of varying size, you and your friends will take piles of coins as follows:
           1.In each step, you will choose any 3 piles of coins (not necessarily consecutive).
           2.Of your choice, Alice will pick the pile with the maximum number of coins.
           3.You will pick the next pile with maximum number of coins.
           4.Your friend Bob will pick the last pile.
           5.Repeat until there are no more piles of coins.
           Given an array of integers piles where piles[i] is the number of coins in the ith pile.
           Return the maximum number of coins which you can have.

Link : https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
'''

class Solution:
    def maxCoins(self, piles: List[int]) -> int:
        count = 0
        piles = sorted(piles , reverse=True)
        short = len(piles)*2//3
        for i in range(1 , short , 2):
            count += piles[i]
        return count
        
