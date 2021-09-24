'''
Question: Given a binary array nums, return the maximum number of consecutive 1's in the array.
  
Link: https://leetcode.com/problems/max-consecutive-ones/
'''

class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        curr_max = 0
        glob_max = 0
        
        for i in nums:
            if(i == 1):
                curr_max += 1
                glob_max = max(glob_max, curr_max)
                
            else:
                curr_max = 0
                
        return glob_max
