package coding.medium;

import java.util.ArrayList;

class FrontMiddleBackQueue {
    public static void main(String[] args) {
        FrontMiddleBackQueue f = new FrontMiddleBackQueue();
        f.pushFront(1);
        f.pushBack(2);
        f.pushMiddle(3);
        f.pushMiddle(4);
        f.popFront();
        f.popMiddle();
        f.popMiddle();
        f.popBack();
        f.popFront();
    }
    private ArrayList<Integer> queue;

    public FrontMiddleBackQueue() {
        queue = new ArrayList();
    }
    
    public void pushFront(int val) {
        queue.add(0, val);
    }
    
    public void pushMiddle(int val) {
        int middle = queue.size() / 2;
        queue.add(middle, val);
    }
    
    public void pushBack(int val) {
        queue.add(val);
    }
    
    public int popFront() {
        if (isEmpty()){
            return -1;
        }

        return queue.remove(0);
    }
    
    public int popMiddle() {
        if (isEmpty()){
            return -1;
        }

        int middle = (queue.size() - 1) / 2;
        return queue.remove(middle);
    }
    
    public int popBack() {
        if (isEmpty()) return -1;
        return queue.remove(queue.size() - 1);
    }

    private boolean isEmpty() {
        return queue.isEmpty();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */