/*
Question : Given an unsorted array of integers, find the length of longest increasing subsequence.

Link : https://leetcode.com/problems/longest-increasing-subsequence/
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1){
            return n;
        }
        
        int[] dp = new int[nums.length];
        int omax = 0;
        
        for(int i = 0; i < dp.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            
            if(dp[i] > omax){
                omax = dp[i];
            }
        }
        return omax;
    }
}
