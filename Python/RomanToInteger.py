'''
Question: Given a roman numeral, convert it to an integer.

Link: https://leetcode.com/problems/roman-to-integer/
'''

class Solution:
    def romanToInt(self, s: str) -> int:
        translation = {
            'I':1,
            'V':5,
            'X':10,
            'L':50,
            'C':100,
            'D':500,
            'M':1000,
        }
        
        val, last = 0, 1000
        for c in s:
            num = translation[c]
            if num <= last:
                val += num
            else:
                val += num - 2 * last
            
            last = num
        return val
