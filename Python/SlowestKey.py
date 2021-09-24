'''
Question: Return the key of the keypress that had the longest duration. If there are multiple 
          such keypresses, return the lexicographically largest key of the keypresses.

Link: https://leetcode.com/problems/slowest-key/
'''

class Solution:
    def slowestKey(self, releaseTimes: List[int], keysPressed: str) -> str:
        ansKey = keysPressed[0]
        ansDuration = releaseTimes[0]
        
        for i in range(1, len(keysPressed)):
            c = keysPressed[i]
            duration = releaseTimes[i] - releaseTimes[i-1]
            
            if(duration > ansDuration or duration == ansDuration and c > ansKey):
                ansKey = c
                ansDuration = duration
                
        return ansKey
