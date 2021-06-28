/*
Question : Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), 
           ans[i] is the number of 1's in the binary representation of i.

Link : https://leetcode.com/problems/counting-bits/
*/

class Solution {
    public int[] countBits(int n)
    {
        int[] res = new int[n+1];
        res[0] = 0;
        for(int i = 1; i<=n; i++)
        {
            res[i] = countBitshelper(i);
        }
        
        return res;
    }
    int countBitshelper(int x)
    {
        if(x <= 0)
            return 0;
        
        return (x % 2 == 0? 0:1) + countBitshelper(x/2);
    }
}
