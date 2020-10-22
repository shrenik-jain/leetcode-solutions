'''
Question : Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
           Return the running sum of nums.

Link : https://leetcode.com/problems/running-sum-of-1d-array/
'''

class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:        
        res = []
        res.append(nums[0])
        
        for i in range(1 , len(nums)):
            res.append(res[i-1] + nums[i])
        
        return res
