package coding.easy;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassNAME MyStack
 * @Description 用两个队列实现栈
 * @Author yu
 * @Date 2023/8/7 18:32
 * @Version 1.0
 */
class MyStack {

    LinkedList<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
    }
    
    public int pop() {
        return queue.removeLast();
    }
    
    public int top() {
        return queue.getLast();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}