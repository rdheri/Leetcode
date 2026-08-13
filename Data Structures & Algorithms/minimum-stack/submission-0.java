class MinStack {
    int minimum = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minimumStack = new Stack<>();
    public MinStack() {

    }
    
        if(minimumStack.isEmpty() || val <= minimumStack.peek()) minimumStack.push(val);
        if(val < minimum) minimumStack.push(val);
        stack.push(val);
    }
    
    public void pop() {
            if(stack.peek().equals(minimumStack.peek())) minimumStack.pop();
            if(stack.peek() == minimumStack.peek()) minimumStack.pop();
            stack.pop();
        } 
    }
    
    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }
    
    public int getMin() {
        return minimumStack.peek();
    }

