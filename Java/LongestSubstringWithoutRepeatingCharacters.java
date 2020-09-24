/*
Question : Given a string s, find the length of the longest substring without repeating characters.

Link : https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int a = 0;
        int b = 0;
        int max = 0;
        
        HashSet <Character> map = new HashSet();
        
        while(b < s.length()) {
            if(!map.contains(s.charAt(b))) {
                map.add(s.charAt(b));
                b++;
                max = Math.max(map.size() , max);
            }     
            else {
                map.remove(s.charAt(a));
                a++;
            }
        }     
        return max;
    }
}
