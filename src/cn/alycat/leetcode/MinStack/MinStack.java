package cn.alycat.leetcode.MinStack;


/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */


public class MinStack {
    /**
     * initialize your data structure here.
     */
    private Node min;
    private Node root;

    public MinStack() {
        min = new Node(-1);
        root = new Node(-1);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    public void push(int x) {
        Node temp = min;
        while (temp != null) {
            if (temp.next==null || x < temp.next.val) {
                Node tNode = temp.next;
                temp.next = new Node(x);
                temp.next.next = tNode;
                break;
            }
            temp = temp.next;
        }
        temp = root.next;
        root.next = new Node(x);
        root.next.next = temp;
    }

    public void pop() {
        if (root.next == null) {
            throw new NullPointerException();
        }
        if (root.next.val == min.next.val) {
            min.next = min.next.next;
        }
        root.next = root.next.next;
    }

    public int top() {
        if (root.next == null) {
            throw new NullPointerException();
        }
        return root.next.val;
    }

    public int getMin() {
        if (min.next == null) {
            throw new NullPointerException();
        }
        return min.next.val;
    }

    class Node {
        Node next;
        int val;

        public Node(int x) {
            this.val = x;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

