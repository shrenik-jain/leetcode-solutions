'''
Question : Given a 32-bit signed integer, reverse digits of an integer.

Link : https://leetcode.com/problems/reverse-integer/
'''

class Solution:
    def reverse(self, x: int) -> int:
        rev = int(str(abs(x))[::-1])
        
        if rev.bit_length()<32:
            if x <0:
                return -rev
            else:
                return rev
        else:
            return 0
        
