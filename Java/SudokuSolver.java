/*
Question : Write a program to solve a Sudoku puzzle by filling the empty cells.
           A sudoku solution must satisfy all of the following rules:
           1.Each of the digits 1-9 must occur exactly once in each row.
           2.Each of the digits 1-9 must occur exactly once in each column.
           3.Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
           The '.' character indicates empty cells.

Link : https://leetcode.com/problems/sudoku-solver/
*/

class Solution {
    public void solveSudoku(char[][] board) {
    
        if(board == null || board.length == 0){
            return;
        }
        Solve(board);
    }
    
    public boolean Solve(char[][] board) {
        
        for(int i = 0 ; i < board.length; i++) 
        {
            for(int j = 0; j < board[0].length; j++) 
            {
                if(board[i][j] == '.')
                {
                    for(char c = '1'; c <= '9'; c++)    // Trial for every entry
                    {
                        if(isValid(board , i , j , c)) 
                        {
                            board[i][j] = c;
                            if(Solve(board))
                                return true;
                            else
                                board[i][j] = '.';  // BackTracking for optimal entry
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board , int x , int y , char val) {
        
        for(int col = 0; col < board[0].length; col++) {    // check for the entry in row
            if(board[x][col] == val)
                return false;
        }
        
        for(int row =0; row < board.length; row++) {        // checks for entry in column
            if(board[row][y] == val) 
                return false;
        }
        
        int smr = x / 3 * 3;
        int smc = y / 3 * 3;
        
        for(int row =0; row < 3; row++) {                   // checks in submatrix
            for(int col = 0; col < 3; col++) {
                if(board[smr + row][smc + col] == val)
                    return false;
            }
        }
        return true;
    }
}
