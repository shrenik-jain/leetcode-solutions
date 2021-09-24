'''
Question: Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
          n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). 
          Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
          Notice that you may not slant the container.

Link: https://leetcode.com/problems/container-with-most-water/
'''

class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1
        area = 0
        while left < right:
            area = max(area, min(height[left], height[right]) * (right - left))
            
            if height[left] < height[right]:
                left += 1
                
            else:
                right -= 1
                
        return area
        
