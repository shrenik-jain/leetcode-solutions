/*
Question : Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
           Your algorithm's runtime complexity must be in the order of O(log n).
           If the target is not found in the array, return [-1, -1].

Link : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int [] result = new int[2];
        result[0] = findStartingIndex(nums , target , 0 , nums.length -1);
        result[1] = findEndingIndex(nums , target , 0 , nums.length -1);    
        
        return result;
    }
    
    private int findStartingIndex(int[] nums, int target, int start, int end) {
        int index = -1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(nums[mid] >= target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
            
            if(nums[mid] == target) index = mid;
        }
        
        return index;
    }
    
    private int findEndingIndex(int[] nums, int target, int start, int end) {
        int index = -1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(nums[mid] <= target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
            
            if(nums[mid] == target) index = mid;
        }
        
        return index;
    }
}
