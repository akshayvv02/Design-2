/*
 * Implements a queue using two stacks (FIFO using LIFO).
 * 1. input: holds newly pushed elements.
 * 2. output: holds reversed elements for dequeueing.

 * - push(x): always push to input stack.
 * - pop(): if output is empty, transfer all input to output (reversing order), then pop from output.     
 * - peek(): same as pop, but returns top of output without removing it.
 * - empty(): returns true if both stacks are empty.
 */

// Time Complexity : O(1) - Amortized Time, O(n) - Worst Case Time	
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
