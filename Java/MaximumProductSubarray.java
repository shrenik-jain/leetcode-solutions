/*
Question : Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Link : https://leetcode.com/problems/maximum-product-subarray/
*/

class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) { return -1;}
        
        int c_max = nums[0];
        int f_max = nums[0];
        int c_min = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            
            int temp = c_max;
            c_max = Math.max(Math.max(c_max * nums[i] , c_min * nums[i]) , nums[i]);
            c_min = Math.min(Math.min(temp * nums[i] , c_min * nums[i]) , nums[i]);
    
            if(c_max > f_max) {
                f_max = c_max;
            }
        }    
        return f_max;  
    }
}
