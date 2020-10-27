/*
Question : Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Link : https://leetcode.com/problems/longest-palindromic-subsequence/
*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        
        int[][] dp = new int[s.length()][s.length()];
        
        for(int g = 0; g < s.length(); g++)
        {
            for(int i = 0 , j = g; j < s.length(); i++ , j++) 
            {
                if(g == 0) {
                    dp[i][j] = 1;
                }
                else if(g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j)? 2 : 1;
                }
                else {
                    
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    }
                    else {
                        dp[i][j] = Math.max(dp[i + 1][j] , dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[0][s.length() - 1]; 
    }
}
