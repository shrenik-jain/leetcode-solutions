class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        memo = {}
        start , end , maxlength = 0 , 0 , 1
        
        if len(s) == 0:
            return 0 
        
        while start < len(s):
            
            if s[start] in memo:
                end = max(end , memo[s[start]]+1)
            
            maxlength = max(maxlength , start-end+1)
            memo[s[start]] = start
            start += 1
            
        return maxlength
                


            
        
