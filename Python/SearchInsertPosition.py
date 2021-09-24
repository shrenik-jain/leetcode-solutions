'''
Question: Given a sorted array of distinct integers and a target value, return the index if the target is found. 
          If not, return the index where it would be if it were inserted in order.
          You must write an algorithm with O(log n) runtime complexity.

Link: https://leetcode.com/problems/search-insert-position/
'''

class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        start = 0
        end = len(nums) - 1
        ans = 0
        
        while(start <= end):
            mid = start + (end - start) // 2
            print(mid)
            
            if(target == nums[mid]):
                return mid
            
            elif(target < nums[mid]):
                end = mid - 1
                
            else:
                start = mid + 1
                ans = start
        
        return ans
