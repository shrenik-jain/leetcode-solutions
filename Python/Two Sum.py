class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        Mapped = {} 
        for i , n in enumerate(nums):
            dif = target - n
            if dif in Mapped:
                return [Mapped[dif] , i]
            Mapped[n] = i
