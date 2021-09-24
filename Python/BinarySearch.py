'''
Question: Given an array of integers nums which is sorted in ascending order, and an integer target, write a 
          function to search target in nums. If target exists, then return its index. Otherwise, return -1.
          You must write an algorithm with O(log n) runtime complexity.

Link: https://leetcode.com/problems/binary-search/
'''

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        start = 0
        end = len(nums) - 1
        
        while(start <= end):
            mid = start + (end - start) // 2
            
            if(nums[mid] == target):
                return mid
            
            elif(target < nums[mid]):
                end = mid - 1
                
            else:
                start = mid + 1
                
        return -1
                
        
