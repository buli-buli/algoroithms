package coding.easy;

import java.util.Stack;

class MyQueue {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
    Stack s1;
    Stack s2;
    Stack active;
    Stack inActive;

    public MyQueue() {
        s1 = new Stack();
        s2 = new Stack();
        active = s1;
        inActive = s2;
    }
    
    public void push(int x) {
        active.add(x);
    }
    
    public int pop() {
        if (inActive.isEmpty()){
            while (!active.isEmpty()){
                inActive.push(active.pop());
            }
        }

        return (int) inActive.pop();
    }
    
    public int peek() {
        if (inActive.isEmpty()){
            while (!active.isEmpty()){
                inActive.push(active.pop());
            }
        }
        return (int) inActive.peek();
    }
    
    public boolean empty() {
        return active.isEmpty() && inActive.isEmpty();
    }
}