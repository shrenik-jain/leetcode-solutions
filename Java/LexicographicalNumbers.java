/*
Question : Given an integer n, return 1 - n in lexicographical order.

Link : https://leetcode.com/problems/lexicographical-numbers/
*/

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; ++i) {
            dfs(res, i, n);
        }
        return res;
    }
    
    private void dfs(List<Integer> res, int cur, int n) {
        if (cur > n) {
            return;
        }
        res.add(cur);
        for (int i = 0; i <= 9 && cur * 10 + i <= n; ++i) {
            dfs(res, cur * 10 + i, n);
        }
    }
}
