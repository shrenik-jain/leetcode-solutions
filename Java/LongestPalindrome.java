/*
Question : Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome 
           that can be built with those letters. Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Link : https://leetcode.com/problems/longest-palindrome/
*/

class Solution {
    public int longestPalindrome(String s) {
        
        int[] char_counts = new int[128];
        
        for(char c : s.toCharArray()) {
            char_counts[c]++;
        }
        int result = 0;
        
        for(Integer char_count : char_counts) {
            result += char_count / 2 * 2;
            
            if(result % 2 == 0 && char_count % 2 == 1) {
                result += 1;
            }
        }
        return result;
    }
}
