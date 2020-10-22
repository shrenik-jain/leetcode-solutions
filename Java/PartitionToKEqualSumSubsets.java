/*
Question : Given an array of integers nums and a positive integer k, 
           find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

Link : https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
*/

class Solution {
  public  boolean canPartitionKSubsets(int[] nums, int k) {

    int t = 0;                
    for(int i=0;i<nums.length;i++) {
        t +=nums[i];
    }
    if(t % k != 0) {
        return false;
    }
    int target = t/k;   

    boolean[]visited = new boolean[nums.length];

    return partition(0,visited,nums,k,target,0); 
  }
    
  public  boolean partition(int index,boolean[]visited,int[]nums,int k,int target,int sum){
      if(k == 0){
          return true;
      }
      if(target == sum){
          return partition(0,visited,nums,k - 1,target,0); 
      }
      
      for(int i = index ; i < nums.length ; i++){
          if(!visited[i] && sum + nums[i] <= target){
              visited[i] = true;
              if(partition(i + 1,visited,nums,k ,target ,sum+nums[i])){
                  return true;
              }
            visited[i] = false;  
          }
      }
      return false;
    }
}
