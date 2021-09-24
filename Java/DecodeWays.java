/*
Question: Given a string s containing only digits, return the number of ways to decode it.
          The answer is guaranteed to fit in a 32-bit integer.

Link: https://leetcode.com/problems/decode-ways/
*/

class Solution {
    public int numDecodings(String s) {
        
        if(s.length() == 0 || s.charAt(0) == '0')
            return 0;
        if(s.length() == 1) 
            return 1;
        
        int []dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i =2; i <= s.length(); i++) {
            int d = Integer.valueOf(s.substring(i-1, i));
            int dd = Integer.valueOf(s.substring(i-2, i));
            
            if(d > 0)
                dp[i] += dp[i-1];
                
            if(dd >= 10 && dd <= 26)
                dp[i] += dp[i-2];
        }
        
        return dp[s.length()];
    }
}
