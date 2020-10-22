/*
Question : Given a non-empty array nums containing only positive integers, 
           find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Link : https://leetcode.com/problems/partition-equal-subset-sum/
*/

class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if(total % 2 != 0) {
            return false;
        }
        
        return Partition(nums , 0 , 0 , total , new HashMap<String , Boolean>());
    }
    
    public boolean Partition(int[] nums , int index , int sum , int total , HashMap<String , Boolean> state) {
        String current = index + "" + sum;
        
        if(state.containsKey(current)){
            return state.get(current);
        }
        if(sum * 2 == total) {
            return true;
        }
        if(sum > total / 2 || index >= nums.length) {
            return false;
        }
        
        boolean found = Partition(nums , index + 1 , sum , total , state) || 
                        Partition(nums , index + 1 , sum + nums[index] , total , state);
        
        state.put(current , found);
        return found;
    }
}
