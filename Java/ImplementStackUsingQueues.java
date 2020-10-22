/*
Question : Implement a last in first out (LIFO) stack using only two queues. 
           The implemented stack should support all the functions of a normal queue (push, top, pop, and empty).
           Implement the MyStack class:
           1.void push(int x) Pushes element x to the top of the stack.
           2.int pop() Removes the element on the top of the stack and returns it.
           3.int top() Returns the element on the top of the stack.
           4.boolean empty() Returns true if the stack is empty, false otherwise.


Link : https://leetcode.com/problems/implement-stack-using-queues/
*/

class MyStack {
    
    Queue <Integer> mainQ;
    Queue <Integer> helperQ;
    
    public MyStack() {
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();       
    }
    
    /** Push element x onto stack. */
    public void push(int x) {   
        while(mainQ.size() > 0) {
            helperQ.add(mainQ.remove());
        }
        mainQ.add(x);
        
        while(helperQ.size() > 0) {
            mainQ.add(helperQ.remove());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return mainQ.remove();      
    }
    
    /** Get the top element. */
    public int top() {
        return mainQ.peek();       
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(mainQ.size() == 0) {
            return true;
        }
        else {
            return false;
        }
        
    }
}
