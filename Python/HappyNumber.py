'''
Question: Write an algorithm to determine if a number n is happy. Return true if n is a happy number, and false if not.
          A happy number is a number defined by the following process:
          - Starting with any positive integer, replace the number by the sum of the squares of its digits.
          - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
          - Those numbers for which this process ends in 1 are happy.
          
Link: https://leetcode.com/problems/happy-number/description/
'''

class Solution:
    def SquareAndSum(self, n):
        ans = 0
        while n:
            ans += (n % 10) * (n % 10)
            n //= 10

        return ans

    def isHappy(self, n: int) -> bool:
        slow = n
        fast = n

        while True:
            slow = self.SquareAndSum(slow)
            fast = self.SquareAndSum(self.SquareAndSum(fast))

            if(slow == fast):
                break

        return slow == 1
        
