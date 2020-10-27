/*
Question : Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
           An input string is valid if:
           1.Open brackets must be closed by the same type of brackets.
           2.Open brackets must be closed in the correct order.


Link : https://leetcode.com/problems/valid-parentheses/
*/

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '[' ) {
                st.push(ch);
            }
            
            else if(ch == ')') {
               boolean val = handleClose(st , '(');
               
               if(val == false) {
                   return val;
               }
            }
            
            else if(ch == '}') {
               boolean val = handleClose(st , '{');
               
               if(val == false) {
                   return val;
               }
            }
            
            else if(ch == ']') {
                boolean val = handleClose(st , '[');  
                
               if(val == false) {
                   return val;
               }
            }
        }
        
        if(st.size() == 0) {
            return true;
        }
        
        else {
            return false;
        }
    }

    public static boolean handleClose(Stack<Character> st , char open_ch) {
        if(st.size() == 0) {
            return false;
        }
            
        else if(st.peek()!= open_ch) {
            return false;
        }
            
        else {
            st.pop();
            return true;
        }
    }
}  
