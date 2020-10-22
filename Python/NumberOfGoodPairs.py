'''
Question : Given an array of integers nums.
           A pair (i,j) is called good if nums[i] == nums[j] and i < j.
           Return the number of good pairs.

Link : https://leetcode.com/problems/number-of-good-pairs/
'''

class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        
        if len(nums) == len(set(nums)):
            return 0
        
        count = 0
        d = {}
    
        for i in nums:
            count += d.get(i , 0)
            d[i] = d.get(i , 0) + 1
        
        return count
