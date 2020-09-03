class Solution:
    def isPalindrome(self, x: int) -> bool:
        rev = 0
        n = x
        
        if x<0:
            return False
        
        while(n!=0):
            rem=n%10
            rev = rev*10+rem
            n = n//10
            
        if x==rev:
            return True
        
        else: 
            return False
