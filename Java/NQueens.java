/*
Question : The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
           Given an integer n, return all distinct solutions to the n-queens puzzle. Each solution contains a distinct board configuration 
           of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Link : https://leetcode.com/problems/n-queens/
*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
               
        List<List<String>> chess = new LinkedList<>();
        backtrack(chess , new int[n] ,0 , n);
        return chess;     
    }
    
    void backtrack(List<List<String>> chess , int [] pos , int index , int n) {
        
        for(int i=0; i<n; i++) {
            pos[index] = i;
            
            if(checkLegal(pos , index , i)) {
                
                if(index + 1 == n){
                    List<String> t = new LinkedList<>();
                    
                    for(int j=0; j<n; j++) {
                        StringBuilder sb = new StringBuilder();
                        
                        for(int k=0; k<n; k++) {
                            sb.append(k == pos[j] ? "Q" : ".");
                        }
                        
                        t.add(sb.toString());
                    }
                    
                    chess.add(t);
                    
                }else {
                    backtrack(chess , pos , index+1 , n);
                }
            }
            
        }
    }
    
    boolean checkLegal(int [] pos , int index , int i) {
        
        for(int j=0; j<index; j++) {
            
            if(pos[index] == pos[j] || 
               Math.abs(index - j) == Math.abs(pos[index] - pos[j])) {
                return false;
            }
        }
        
        return true;
    }
}
