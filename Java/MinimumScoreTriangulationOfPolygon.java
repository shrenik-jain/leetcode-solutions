/*
Question : Given N, consider a convex N-sided polygon with vertices labelled A[0], A[i], ..., A[N-1] in clockwise order.
           Suppose you triangulate the polygon into N-2 triangles.  For each triangle, the value of that triangle is the product of the 
           labels of the vertices, and the total score of the triangulation is the sum of these values over all N-2 triangles in the triangulation.
           Return the smallest possible total score that you can achieve with some triangulation of the polygon.

Link : https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
*/

class Solution {
    public int minScoreTriangulation(int[] A) {
        
        int n = A.length;
        int[][] dp = new int[n][n];
        
        for(int g = 2; g < n; g++)
        {
            for(int i = 0 , j = g; j < n; i++ , j++)
            {
                dp[i][j] = Integer.MAX_VALUE;
                
                for(int k = i + 1; k < j; k++)
                {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[j]                                                                             * A[k]);

                }
            }
        }
        
        return dp[0][n - 1];    
    }
}
