'''
Question : Given an integer number n, return the difference between the product of its digits and the sum of its digits. 

Link : https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
'''

class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        pro = 1
        add = 0
        
        while(n > 0):
            rem = n % 10
            add += rem
            pro *= rem
            n = n // 10
            
        return pro - add
        
