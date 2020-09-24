'''
Question : Given an array of size n, find the majority element. 
           The majority element is the element that appears more than ⌊ n/2 ⌋ times.
           You may assume that the array is non-empty and the majority element always exist in the array.

Link : https://leetcode.com/problems/majority-element/
'''

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        majority = nums[0]
        count = 1
        
        for i in nums:
            if i == majority:
                count += 1
            
            else:
                count -= 1
                if count == 0:
                    majority = i
                    count = 1
        
        return majority
