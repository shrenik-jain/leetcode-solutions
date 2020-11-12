/*
Question : Given an integer array arr and an integer k, modify the array by repeating it k times.
           For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].
           Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.
           As the answer can be very large, return the answer modulo 10^9 + 7.

Link : https://leetcode.com/problems/k-concatenation-maximum-sum/
*/

class Solution {
    
    public long kadane(int[] arr) {
        long csum = arr[0];
        long osum = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            if(csum >= 0) 
                csum += arr[i];
            else
                csum = arr[i];
            
            if(csum > osum)
                osum = csum; 
        }
        return osum;
    }
    
    public long kadaneOfTwo(int[] arr) {
        int[] narr = new int[arr.length * 2];
        
        for(int i = 0; i < arr.length; i++) {
            narr[i] = arr[i];
        }
        
        for(int i = 0; i < arr.length; i++) {
            narr[i + arr.length] = arr[i];
        }
        return kadane(narr);
    }
    
    public int kConcatenationMaxSum(int[] arr, int k) {
        long res = 0;
        long mod = 1000000007;
        long sum = 0;
        
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        
        if(k == 1) {
            res = kadane(arr);
        }
        else if(sum < 0) {
            res = kadaneOfTwo(arr);
        }
        else {
            res = kadaneOfTwo(arr) + (k - 2) * sum;
        }
        
        if (res < 0) 
            return 0;
        
        return (int)(res % mod);
    }
}
