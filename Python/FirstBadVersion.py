'''
Question: You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest 
          version of your product fails the quality check. Since each version is developed based on the previous 
          version, all the versions after a bad version are also bad. You are given an API bool isBadVersion(version) 
          which returns whether version is bad. Implement a function to find the first bad version. You should minimize 
          the number of calls to the API.

Link: https://leetcode.com/problems/first-bad-version/
'''


# The isBadVersion API is already defined for you.
# @param version, an integer
# @return an integer
# def isBadVersion(version):

class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        low = 1
        high = n 
        
        while(low < high):
            mid = low + (high - low) // 2
            
            if(isBadVersion(mid) == False):
                low = mid + 1
            else:
                high = mid
                
        return low 
