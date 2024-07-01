package udemyds.stack;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int top;

    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        top = -1;
    }

    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    public int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        // Move all elements except the last one from queue1 to queue2
        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }
        // The last element is the element to pop
        int poppedElement = queue1.remove();
        // Swap the names of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return poppedElement;
    }

    public int top() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element is: " + stack.top()); // Should print 3
        System.out.println("Popped element is: " + stack.pop()); // Should print 3
        System.out.println("Top element is: " + stack.top()); // Should print 2
        System.out.println("Is stack empty? " + stack.empty()); // Should print false
    }
}
