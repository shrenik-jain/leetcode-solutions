/*
Question : Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.

Link : https://leetcode.com/problems/first-unique-character-in-a-string/
*/

class Solution {
    public int firstUniqChar(String s) 
    {
        int strlen = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        if(strlen == 1)
            return 0;
        
        for(int i = 0; i < strlen; i++)
        {
            char c = s.charAt(i);
            if(!map.containsKey(c))
                map.put(c, 1);
                
            else
                map.put(c, map.get(c) + 1);
        }
        for(int i = 0; i < strlen; i++)
        {
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
