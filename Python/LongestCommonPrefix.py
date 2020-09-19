'''
Question : Write a function to find the longest common prefix string amongst an array of strings.
           If there is no common prefix, return an empty string "".

Link : https://leetcode.com/problems/longest-common-prefix/
'''

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:

        s = ""
        
        if len(strs) == 0:
            return s
        
        elif len(strs) == 1:
            return strs[0]
        
        for i in range(len(min(strs))):
            
            for j in range(1,len(strs)):
                
                if strs[0][i] == strs[j][i]:
                    
                    if j == len(strs)-1: 
                        s = s + strs[0][i]
                    
                else:
                    return s
        return s
