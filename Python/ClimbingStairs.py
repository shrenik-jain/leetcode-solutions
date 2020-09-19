'''
Question : You are climbing a stair case. It takes n steps to reach to the top.
           Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Link : https://leetcode.com/problems/climbing-stairs/
'''

class Solution:
    def climbStairs(self, n: int) -> int:
        memo = [0 for _ in range(n+1)]
        memo[0] = 1
        
        for i in range(1,n+1):
            if i==1:
                memo[i] = memo[i-1]
            else:
                memo[i] = memo[i-1] + memo[i-2]
            
        return memo[n]
