class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int value) {
        stack.push(value);
        
        if(minStack.isEmpty() || minStack.peek() >= value)
            minStack.push(value);
    }
    
    public void pop() {
        if(stack.peek().equals(minStack.peek()))
            minStack.pop();

        stack.pop();
    }
    
    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }
    
    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */