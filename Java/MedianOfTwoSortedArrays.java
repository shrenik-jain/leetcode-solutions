/*
Question : Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
           Follow up: The overall run time complexity should be O(log (m+n)).

Link : https://leetcode.com/problems/median-of-two-sorted-arrays/
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        int [] res = new int [m + n];
        int i = 0 , j = 0 , k = 0;
        
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                res[k] = nums1[i];
                i++;
                k++;
            }
            else {
                res[k] = nums2[j];
                j++;
                k++;
            }
        }
        
        while(i < m) {
            res[k] = nums1[i];
            i++;
            k++;
        }
        
        while(j < n) {
            res[k] = nums2[j];
            j++;
            k++;
        }
        
        if((m + n) % 2 != 0) {
            return res[(m + n)/2];
        }
        else {
            int x = (m + n) / 2;
            double p = res[x];
            double q = res[x-1];
            return (p + q) / 2;
        }
    }
}
