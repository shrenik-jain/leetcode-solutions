/*
Question : Find the kth largest element in an unsorted array. 
           Note that it is the kth largest element in the sorted order, not the kth distinct element.

Link : https://leetcode.com/problems/kth-largest-element-in-an-array/
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {   
    
        PriorityQueue <Integer> minHeap = new PriorityQueue<>();
        
        for(int i=0; i<k; i++) {
            minHeap.add(nums[i]);
        }      
        for(int i=k; i<nums.length; i++){
            if(nums[i] > minHeap.peek()) {
                minHeap.remove();
                minHeap.add(nums[i]);
            }
        }        
        return minHeap.peek();
    }
}
