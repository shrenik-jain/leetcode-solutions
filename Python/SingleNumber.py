'''
Question : Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
           Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

Link : https://leetcode.com/problems/single-number/
'''

from collections import defaultdict

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        mapped = defaultdict(int)
        
        for i in nums:
            mapped[i] += 1
            
        for i in mapped:
            if mapped[i] == 1:
                return i
