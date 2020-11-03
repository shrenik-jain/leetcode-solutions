/*
Question : Given n, how many structurally unique BST's (Binary Search Trees) that store values 1...n?

Link : https://leetcode.com/problems/unique-binary-search-trees/
*/

class Solution {
    public int numTrees(int n) {
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i < dp.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
