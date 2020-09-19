'''
Question : Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
           Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Link : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
'''

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        index = 1
        
        while index < len(nums):
            
            if nums[index] == nums[index-1]:
                nums.pop(index)
                
            else:
                index += 1
                
        return len(nums)
