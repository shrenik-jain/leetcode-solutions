/*
Question : Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

Link : https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
*/

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        if(s1.length() == 0 && s2.length() == 0)
            return 0; 
        
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        
        for(int i = dp.length - 1; i >= 0; i--)
        {
            for(int j = dp[0].length - 1; j >= 0; j--) 
            {
                if(i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = 0;
                }
                else if(i == dp.length - 1) {
                    dp[i][j] = (int)s2.charAt(j) + dp[i][j + 1];
                }
                else if(j == dp[0].length - 1) {
                    dp[i][j] = (int)s1.charAt(i) + dp[i + 1][j]; 
                }
                else 
                {
                    if(s1.charAt(i) == s2.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                    else {
                        dp[i][j] = Math.min(s1.charAt(i) + dp[i + 1][j] , s2.charAt(j) + dp[i][j + 1]);
                    }
                }
            }
        }
        return dp[0][0];
    }
}
