class MyQueue {

    Stack<Integer> s;
    public MyQueue() {
        s = new Stack<>();
    }
    
    public void push(int x) {
        s.push(x);
    }
    
    private static void reverseStack(Stack<Integer> s){
        Queue<Integer> q = new LinkedList<>();
        while(!s.isEmpty()){
            q.offer(s.pop());
        }
        while(!q.isEmpty()){
            s.push(q.poll());
        }
    }

    public int pop() {
        reverseStack(s);
        int popElement = s.pop();
        reverseStack(s);
        return popElement;
    }
    
    public int peek() {
        reverseStack(s);
        int topElement = s.peek();
        reverseStack(s);
        return topElement;
    }
    
    public boolean empty() {
        return s.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */