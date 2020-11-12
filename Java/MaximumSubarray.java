/*
Question : Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Link : https://leetcode.com/problems/maximum-subarray/
*/

class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        int csum = nums[0]; 
        int osum = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            if(csum >= 0) {
                csum += nums[i];
            }
            else {
                csum = nums[i];
            }
            
            if(csum > osum) {
                osum = csum;
            }
        }
        return osum;
    }
}
