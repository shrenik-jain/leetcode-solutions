/*
Question : You are given K eggs, and you have access to a building with N floors from 1 to N. 
           Each egg is identical in function, and if an egg breaks, you cannot drop it again.
           You know that there exists a floor F with 0 <= F <= N such that any egg dropped at a floor higher than F will break, 
           and any egg dropped at or below floor F will not break.
           Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= N). 
           Your goal is to know with certainty what the value of F is.
           What is the minimum number of moves that you need to know with certainty what F is, regardless of the initial value of F?

Link : https://leetcode.com/problems/super-egg-drop/
*/

class Solution {
    public int superEggDrop(int K, int N) {
        int[][] memo = new int[K + 1][N + 1];
        return dp(K , N , memo);
    }
    int dp(int k , int n , int[][] memo) {
        if(n == 0) 
            return 0;
        if(k == 1)
            return n;
        if(memo[k][n] != 0)
            return memo[k][n];
        
        int res = n;
        int low = 1;
        int high = n;
        
        while(low <= high) 
        {
            int mid = (high - low) / 2 + low;
            
            int left = dp(k - 1 , mid - 1 , memo);  //egg breaks hence k - 1
            int right = dp(k , n - mid , memo);     //egg survives hence k
            int max = Math.max(left , right) + 1;
            res = Math.min(max , res);
            
            if(left == right)
                break;
            else if(left < right)
                low = mid + 1;
            else 
                high = mid - 1;
        }
        
        memo[k][n] = res;   
        return res;
    }
}
