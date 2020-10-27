/*
Question : Given two strings text1 and text2, return the length of their longest common subsequence.
           A subsequence of a string is a new string generated from the original string with some 
           characters(can be none) deleted without changing the relative order of the remaining characters. 
           (eg "ace" is a subsequence of "abcde" while "aec" is not). 
           A common subsequence of two strings is a subsequence that is common to both strings.

Link : https://leetcode.com/problems/longest-common-subsequence/
*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        if(text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        
        int[][] dp = new int[text1.length() + 1][text2.length() +1];
        
        for(int i = dp.length - 2; i >= 0; i--)
        {
            for(int j = dp[0].length - 2; j >= 0; j--)
            {
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);
                
                if(c1 == c2) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j] , dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
