
/*
Question : Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. 
           That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
Link : https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
*/

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] smaller = new int[101];
        
        for(int i = 0; i < nums.length; i++) {
            smaller[nums[i]]++;
        }
        for(int i = 1; i < 101; i++) {
            smaller[i] += smaller[i-1];    
        }
        for(int i = 0; i < nums.length; i++) {
            int pos = nums[i];
            if(pos == 0) {
                nums[i] = 0;
            }
            else {
                nums[i] = smaller[pos - 1];
            }
        }
        return nums;
    }
}
