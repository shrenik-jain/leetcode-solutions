/*
Question : Given a string, your task is to count how many palindromic substrings in this string.
           The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Link : https://leetcode.com/problems/palindromic-substrings/
*/

class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        
        for(int g = 0; g < s.length(); g++) 
        {
            for(int i = 0 , j = g; j < s.length(); i++ , j++)
            {
                if(g == 0) {
                    dp[i][j] = true;
                }
                else if(g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j)? true : false;
                }
                else {
                    
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    else {
                        dp[i][j] = false;
                    }
                }
                if(dp[i][j] == true) {
                    count++;
                }
            }
        }
        return count;
    }
}
