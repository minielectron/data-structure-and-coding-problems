package udemyds.stack;

import java.util.Stack;

public class MinAndMaxStack {
    // The aim is to design and algorithm that can return the maximum item of a stack in O(1).
    // We can use O(N) extra space

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> maxStack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public void push(int data) {
        stack.push(data);
        if (stack.size() == 1) {
            maxStack.push(data);
            minStack.push(data);
        } else {
            // Check for max stack
            if (stack.peek() < maxStack.peek()) {
                maxStack.push(maxStack.peek());
            } else {
                maxStack.push(data);
            }
            // Check for min stack
            if (stack.peek() > minStack.peek()) {
                minStack.push(minStack.peek());
            } else {
                minStack.push(data);
            }
        }
    }

    public void pop() {
        stack.pop();
        maxStack.pop();
    }

    public int getMax() {
        if (maxStack.isEmpty()) return -1;
        return maxStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }

}
