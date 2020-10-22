/*
Question : Given a string s of '(' , ')' and lowercase English characters. 
           Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) 
           so that the resulting parentheses string is valid and return any valid string.
           Formally, a parentheses string is valid if and only if:
           1.It is the empty string, contains only lowercase characters, or
           2.It can be written as AB (A concatenated with B), where A and B are valid strings, or
           3.It can be written as (A), where A is a valid string.


Link : https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
*/

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        
        for(char c : s.toCharArray()) {
            if(c == '(') {
                open++;
            }
            else if(c == ')') {
                if(open == 0) {
                    continue;
                }
                open--;
            }
            sb.append(c);
        }
        StringBuilder res = new StringBuilder();
        
        for(int i = sb.length()-1; i >= 0; i--) {
            if(sb.charAt(i) == '(' && open-- > 0) {
                continue;
            }
            res.append(sb.charAt(i));
        }
        return res.reverse().toString();
    }
}
