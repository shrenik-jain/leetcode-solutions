'''
Question : Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
           Note: The algorithm should run in linear time and in O(1) space.

Link : https://leetcode.com/problems/majority-element-ii/
'''

class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        n1 = n2 = -1
        c1 = c2 = 0
        n = len(nums)
        res = []
        
        for i in nums:
            if i == n1:
                c1 += 1
                
            elif i == n2:
                c2 += 1
                
            elif c1 == 0:
                n1 = i
                c1 = 1
                
            elif c2 == 0:
                n2 = i
                c2 = 1
                
            else:
                c1 -= 1
                c2 -= 1
        
        if nums.count(n1) > n//3:
            res.append(n1)
            
        if nums.count(n2) > n//3:
            res.append(n2)
        
        return res
        
