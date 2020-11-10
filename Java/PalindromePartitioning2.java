/*
Question : Given a string s, partition s such that every substring of the partition is a palindrome.
           Return the minimum cuts needed for a palindrome partitioning of s.

Link : https://leetcode.com/problems/palindrome-partitioning-ii/
*/

class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for(int g = 0; g < n; g++)
        {
            for(int i = 0, j = g; j < dp.length; i++, j++)
            {
                if(g == 0) {
                    dp[i][j] = true;
                }
                else if(g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? true : false;
                }
                else {
                    
                    if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true)
                        dp[i][j] = true;
                    else
                        dp[i][j] = false;
                }
            }
        }
        
        int[] cuts = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            if(dp[0][i] == true){
                cuts[i] = 0;
            }
            else 
            {  
              cuts[i] = Integer.MAX_VALUE;
              for (int j = 0; j < i; j++) 
              {
                if(dp[j + 1][i] == true && 1 + cuts[j] < cuts[i]){
                  cuts[i] = 1 + cuts[j];
                }
              }
            }
        }
        return cuts[n - 1];
    }
}
