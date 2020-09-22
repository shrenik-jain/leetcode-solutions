'''
Question : Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
           You may assume that each input would have exactly one solution, and you may not use the same element twice.
           You can return the answer in any order.

Link : https://leetcode.com/problems/two-sum/
'''

class Solution(object):
    def twoSum(self, nums, target):
        Mapped = {} 
        for i , n in enumerate(nums):
            dif = target - n
            if dif in Mapped:
                return [Mapped[dif] , i]
            Mapped[n] = i
