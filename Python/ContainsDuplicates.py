'''
Question : Given an array of integers, find if the array contains any duplicates.
           Your function should return true if any value appears at least twice in the array, 
           and it should return false if every element is distinct.

Link : https://leetcode.com/problems/contains-duplicate/
'''

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        return len(nums) > len(set(nums))
