/*
Question : Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
           An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
           You may assume all four edges of the grid are all surrounded by water.

Link : https://leetcode.com/problems/number-of-islands/
*/

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        else if(grid.length == 1) {
            if(grid[0][0] == 0) { return 0; }   
            else if(grid[0][0] == 1) { return 1; }
        }
        
        int count = 0;
        boolean [][] visited = new boolean [grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {   
                if(grid[i][j] == '1' && visited[i][j] == false) {
                    drawTree(grid , i , j , visited);
                    count++;
                }
            }
        }  
        
        return count;
    }
    
    public static void drawTree(char[][] grid , int i , int j , boolean[][] visited) {
        
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0' || visited[i][j]==true) {
            return;
        }
        
        visited[i][j] = true;
        drawTree(grid , i-1 , j , visited);
        drawTree(grid , i , j+1 , visited);
        drawTree(grid , i , j-1 , visited);
        drawTree(grid , i+1 , j , visited);
    } 
}
