/*
Question : Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
           1.Integers in each row are sorted from left to right.
           2.The first integer of each row is greater than the last integer of the previous row.


Link : https://leetcode.com/problems/search-a-2d-matrix/
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int left = 0;
        int right = rows * cols - 1;
        
        while(left <= right) 
        {
            int mid = left + (right - left) / 2;
            int mid_element = matrix[mid / cols][mid % cols];
            
            if(target == mid_element) {
                return true;
            }
            else if(target < mid_element) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }
}
