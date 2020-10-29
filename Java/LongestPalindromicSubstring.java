/*
Question : Given a string s, return the longest palindromic substring in s.

Link : https://leetcode.com/problems/longest-palindromic-substring/
*/

class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) {
            return "";
        }  
        
            int start = 0;
            int  end = 0;
            
        for(int i = 0; i < s.length(); i++)
        {
            int l1 = expandFromMid(s , i , i);
            int l2 = expandFromMid(s , i , i + 1);
            int len = Math.max(l1 , l2);

            if(len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start , end + 1);
    }
    
    public int expandFromMid(String s , int left , int right) {
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
