'''
Question: Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
          You can use each character in text at most once. Return the maximum number of instances that can be formed.

Link: https://leetcode.com/problems/maximum-number-of-balloons/
'''

class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        word = {'a':0, 'b':0, 'l':0, 'n':0, 'o':0}
        double_char = ['l', 'o']
        
        for c in text:
            if c in word:
                word[c] += 1
                
        for c in double_char:
            word[c] //= 2
            
        return min(word.values())
        
