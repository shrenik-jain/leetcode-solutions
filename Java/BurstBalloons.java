/*
Question : Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. 
           You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
           Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
           Find the maximum coins you can collect by bursting the balloons wisely.

Link : https://leetcode.com/problems/burst-balloons/
*/

class Solution {
    public int maxCoins(int[] nums) {
        
        int n = nums.length;
        if(n == 0)
            return 0;
        
        int[][] dp = new int[n][n];
        
        for(int g = 0; g < n; g++)
        {
            for(int i = 0 , j = g; j < n; i++ , j++)
            {
                int max = Integer.MIN_VALUE;
                
                for(int k = i; k <= j; k++)
                {
                    int left = k == i? 0 : dp[i][k - 1];
                    int right = k == j? 0 : dp[k + 1][j];
                    int val = (i == 0? 1 : nums[i - 1]) * nums[k] * (j == n - 1? 1 : nums[j + 1]);
                    
                    int total = left + right + val;
                    
                    if(total > max)
                        max = total;
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n - 1];
    }
}
