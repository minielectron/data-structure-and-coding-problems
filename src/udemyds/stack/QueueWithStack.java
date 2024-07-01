package udemyds.stack;

import java.util.Stack;

public class QueueWithStack {

    private final Stack<Integer> enqueueStack = new Stack<>();
    private final Stack<Integer> dequeueStack = new Stack<>();

    public void enqueue(int data) {
        enqueueStack.push(data);
    }

    public int dequeue() {
        if (enqueueStack.isEmpty() && dequeueStack.isEmpty()) return -1;

        /// If the dequeueStack is empty we have to add items O(N)
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }

        return dequeueStack.pop();
    }
}
