'''
Question: Given an integer, convert it to a roman numeral.

Link: https://leetcode.com/problems/integer-to-roman/
'''

class Solution:
    def intToRoman(self, num: int) -> str:
        translation = {
            'M': 1000,
            'CM': 900,
            'D': 500,
            'CD': 400,
            'C': 100,
            'XC': 90,
            'L': 50,
            'XL': 40,
            'X': 10,
            'IX': 9,
            'V': 5,
            'IV': 4,
            'I': 1,
        }
        out = ''
        for s,n in translation.items():
            out += num // n * s
            num %= n
        
        return out

        
