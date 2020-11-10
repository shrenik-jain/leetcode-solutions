/*
Question : 

Link :
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
