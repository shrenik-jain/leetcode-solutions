/*
Question : Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.

Link : https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
*/

class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i=0; i<A.length; i++) {
            sum += A[i];
        }
        if(sum % 3 != 0) {
            return false;
        }

        int target = sum / 3;
        int accum = 0 , count = 0; 
        for(int i=0; i<A.length; i++) {
            if(count == 2) {
                return true;
            }
            accum += A[i];
            if(accum == target) {
                accum = 0;
                count++;
            }
        }
        return false;
    }
}
